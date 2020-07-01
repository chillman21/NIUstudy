package niu.study.thread.JUC.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class BlockQueue_ThrowException {
    public static void main(String[] args) {
        test1();
    }
    /**
     * 抛出异常
     */
    public static void test1(){
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
        System.out.println(blockingQueue.element());//查看队首元素是谁
        System.out.println("-----------------");
        //抛出异常！ java.lang.IllegalStateException: Queue full
        //System.out.println(blockingQueue.add("d"));//阻塞

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        //抛出异常！java.util.NoSuchElementException
        //System.out.println(blockingQueue.remove());

    }

}
