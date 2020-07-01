package niu.study.thread.JUC.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 异步调用：CompletableFuture
 *      异步执行
 *      成功回调
 *      失败回调
 *
 */
public class FutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //没有返回指定runAsync 异步回调
//        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
//            try {
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName()+" runAsync");
//        });
//        System.out.println("11111");
//        completableFuture.get();//阻塞获取执行结果
        //有返回值的supplyAsync异步回调
        //ajax,成功和失败的回调
        //返回的是错误信息
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName()+" supplyAsync");
            int i= 1/0;
            return 1024;
        });
        System.out.println(completableFuture.whenComplete((t, u) -> {
            System.out.println("t=>" + t);//正常的返回结果
            System.out.println("u=>" + u);//错误信息
        }).exceptionally((e) -> {
            System.out.println(e.getMessage());
            return 233;//可以获取到错误情况下的返回值
        }).get());
    }
}
