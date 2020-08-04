package niu.study.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author NIU
 * @createTime 2020/7/28 21:36
 */
public class InterruptTest {

    public synchronized void foo1() throws InterruptedException{
        System.out.println("foo1 begin");
        for (int i =0; i < 5; ++i) {
            System.out.println("foo1 ...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("foo1 sleep is interrupted, msg=" + e.getMessage());
            }
        }
    }

    public synchronized void foo2() throws InterruptedException {
        System.out.println("foo2 begin");
        for (int i =0; i < 100; ++i) {
            System.out.println("foo2 ...");
            Thread.sleep(1000);
        }
    }

    public static void main(String[] args) {
        InterruptTest it = new InterruptTest();
        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(() -> {
            try {
                it.foo2();
            } catch (InterruptedException e) {
                System.out.println("foo2 is interrupted, msg=" + e.getMessage());
            }
        });
        es.execute(() -> {
            try {
                it.foo1();
            } catch (InterruptedException e) {
                System.out.println("foo1 is interrupted, msg=" + e.getMessage());
            }
        });

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        es.shutdownNow();
        System.out.println("Main end");
    }
}