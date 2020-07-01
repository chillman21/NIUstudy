package niu.study.thread.JUC;

import java.util.concurrent.*;

public class ThreadPoolDemo2 {
    public static void main(String[] args) {
        /**
         * 自定义线程池
         * 重点！四种拒绝策略：
         *      ThreadPoolExecutor.AbortPolicy() 银行满了，还有人进来，不处理这个人的请求，抛出异常
         *      ThreadPoolExecutor.CallerRunsPolicy() 哪来的回哪去！被拒绝的任务由原来创建线程池的线程执行
         *      ThreadPoolExecutor.DiscardPolicy() 队列满了，丢掉任务，但是不会抛出异常，也不会阻塞
         *      ThreadPoolExecutor.DiscardOldestPolicy() 队列满了，尝试和最早的进程竞争，也不会抛出异常
         */
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                2,
                5,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()//银行满了，还有人进来，不处理这个人的请求，抛出异常
        );
        try{
            //最大承载：队列容量+max线程容量
            for (int i = 1; i <= 8; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"ok");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //用完关闭线程池
            threadPool.shutdown();
        }
    }
}
