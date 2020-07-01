package niu.study.thread.JUC.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class BlockQueue_ForeverWaiting {
    public static void main(String[] args) throws InterruptedException {
        test3();
    }
    /**
     * 抛出异常
     */
    public static void test3() throws InterruptedException {
        ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        //队伍没有位置了，一直阻塞
        //blockingQueue.put("d");
        System.out.println("-----------------");
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        //没有元素了,再取出会一直阻塞
        System.out.println(blockingQueue.take());

    }

}
