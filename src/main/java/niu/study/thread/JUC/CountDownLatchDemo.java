package niu.study.thread.JUC;

import java.util.concurrent.CountDownLatch;

/**
 * 计数器
 */

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        //倒计时
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"Go out");
                countDownLatch.countDown();//-1
            },String.valueOf(i)).start();
        }
        countDownLatch.await();//等待计数器归零，然后继续执行
        System.out.println("结束");
    }
}
