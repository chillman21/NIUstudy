package niu.study.thread.JUC.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class BlockQueue_NoThrowException {
    public static void main(String[] args) {
        test2();
    }
    /**
     * 不抛出异常，有返回值
     */
    public static void test2(){
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.peek());//检测队首元素
        System.out.println("-----------------");
        //不抛出异常
        System.out.println(blockingQueue.offer("d"));
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        //返回null
        System.out.println(blockingQueue.poll());
    }

}
