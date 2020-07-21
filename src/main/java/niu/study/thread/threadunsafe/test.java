package niu.study.thread.threadunsafe;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class test {
    public static void main(String[] args){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        Callable<Date> callable = new Callable<Date>() {
            @Override
            public Date call() throws Exception {
                //由于线程非安全，所以往pool中同时放入100个任务并开启10000个线程去执行如下
                //的代码就会报错。100不报错，就改成1000,1000不报错就改成10000.你的机子
                //越牛逼。这个数字就越大。但是肯定会报错
                return sdf.parse("20181012");
            };
        };



        List<Future<Date>> dates = new ArrayList();
        ExecutorService pool = Executors.newFixedThreadPool(10);
        for(int i=0;i<2;i++){
            dates.add(pool.submit(callable));
        }

        dates.forEach((Future<Date> dateFuture) -> {
            try {
                System.out.println(dateFuture.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        pool.shutdown();
    }
}
