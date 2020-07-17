package niu.study.thread.completablefuture;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class QueryUserService {
    private Supplier<QueryUtils> queryUtilsSupplier = QueryUtils::new;
    public UserInfo converUserInfo(UserInfo userInfo) {
        QuerySupplier querySuppiler1 = new QuerySupplier(userInfo.getCarId(), "car", new QueryUtils());
        CompletableFuture<String> getCarDesc = CompletableFuture.supplyAsync(querySuppiler1);
        getCarDesc.thenAccept(new Consumer<String>() {  //1
            @Override
            public void accept(String carDesc) {
                userInfo.setCarDes(carDesc);
            }
        });
        QuerySupplier querySuppiler2 = new QuerySupplier(userInfo.getHomeId(), "home", queryUtilsSupplier.get());
        CompletableFuture<String> getHomeDesc = CompletableFuture.supplyAsync(querySuppiler2);
        getHomeDesc.thenAccept(new Consumer<String>() {  //2
            @Override
            public void accept(String homeDesc) {
                userInfo.setHomeDes(homeDesc);
            }
        });
        QuerySupplier querySuppiler3 = new QuerySupplier(userInfo.getJobId(), "job", queryUtilsSupplier.get());
        CompletableFuture<String> getJobDesc = CompletableFuture.supplyAsync(querySuppiler3);
        getJobDesc.thenAccept(new Consumer<String>() {  //3
            @Override
            public void accept(String jobDesc) {
                userInfo.setJobDes(jobDesc);
            }
        });
        CompletableFuture<Void> getUserInfo = CompletableFuture.allOf(getCarDesc, getHomeDesc, getJobDesc);
        getUserInfo.thenAccept(new Consumer<Void>() {
            @Override
            public void accept(Void result) {
                System.out.println("全部完成查询" );
            }
        });
        getUserInfo.join();  //4
        return userInfo;
    }
    public static void main(String[] args) {
        System.out.println();
        long begin= System.currentTimeMillis();
        //多线程环境需要注意线程安全问题
        List<UserInfo> userInfoList= Collections.synchronizedList(new ArrayList<>());
        for(int i=0;i<=20;i++){
            UserInfo userInfo=new UserInfo();
            userInfo.setId(i);
            userInfo.setName("username"+i);
            userInfo.setCarId(i);
            userInfo.setJobId(i);
            userInfo.setHomeId(i);
            userInfoList.add(userInfo);
        }
        //stream 查询一个用户花费3s  并行计算后一个用户1秒左右 查询21个用户花费21秒
        //parallelStream 速度更慢
        userInfoList.stream()
                .map(userInfo->{
                    QueryUserService queryUserService=new QueryUserService();
                    userInfo =queryUserService.converUserInfo(userInfo);
                    return userInfo;
                }).collect(Collectors.toList());
        System.out.println("=============");
        long end=System.currentTimeMillis();
        System.out.println(end-begin);
    }
}
