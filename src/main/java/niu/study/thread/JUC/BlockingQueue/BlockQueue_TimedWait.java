package niu.study.thread.JUC.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockQueue_TimedWait {
    public static void main(String[] args) throws InterruptedException {
        test4();
    }
    /**
     * 抛出异常
     */
    public static void test4() throws InterruptedException {
        ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        blockingQueue.offer("a");
        blockingQueue.offer("b");
        blockingQueue.offer("c");
        //等待，超过两秒插入不进去就退出
        //blockingQueue.offer("d",2, TimeUnit.SECONDS);
        System.out.println("--------");
        blockingQueue.poll();
        blockingQueue.poll();
        blockingQueue.poll();
        //等待，超过两秒弹不出来就退出
        blockingQueue.poll(2, TimeUnit.SECONDS);


    }

}
