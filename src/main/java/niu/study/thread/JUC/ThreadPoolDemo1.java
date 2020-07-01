package niu.study.thread.JUC;

import java.util.concurrent.*;

public class ThreadPoolDemo1 {
    public static void main(String[] args) {
        /**
         * 重点：线程三大方法
         *       七大参数
         *        四种拒绝策略
         */
        //最大线程数到底该如何定义？（调优）
        //1、CPU 密集型：几核CPU就是几，因为可以并行，可保持CPU效率最高
        //2、IO密集型：判断你程序中IO十分耗资源的线程 多留点
        System.out.println(Runtime.getRuntime().availableProcessors());//获取CPU核数
        ExecutorService threadPool = Executors.newSingleThreadExecutor();//单个线程
        ExecutorService threadPool2 = Executors.newFixedThreadPool(5);//创建一个固定大小的线程池
        ExecutorService threadPool3 = Executors.newCachedThreadPool();//可伸缩的
        try {
            for (int i = 0; i < 10; i++) {
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
    /* 源码解读： 七大参数！
    public ThreadPoolExecutor(int corePoolSize, //核心线程池大小
                              int maximumPoolSize, //最大线程池大小
                              long keepAliveTime, //超时了没有人调用就会释放
                              TimeUnit unit,//超时单位
                              BlockingQueue<Runnable> workQueue, //阻塞队列
                              ThreadFactory threadFactory,  //线程工厂:创建线程的工厂对象，一般不用动
                              RejectedExecutionHandler handler) { //拒绝策略
        if (corePoolSize < 0 ||
                maximumPoolSize <= 0 ||
                maximumPoolSize < corePoolSize ||
                keepAliveTime < 0)
            throw new IllegalArgumentException();
        if (workQueue == null || threadFactory == null || handler == null)
            throw new NullPointerException();
        this.acc = System.getSecurityManager() == null ?
                null :
                AccessController.getContext();
        this.corePoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.workQueue = workQueue;
        this.keepAliveTime = unit.toNanos(keepAliveTime);
        this.threadFactory = threadFactory;
        this.handler = handler;
    }
    */
}
