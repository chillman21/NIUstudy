package niu.study.thread.JUC.VolatileDemo;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile
 * 1.保证可见性
 * 2.不保证原子性
 * 3.禁止指令重排
 */
public class JMMDemo {
    //不加volatile 程序就会死循环
    //加volatile 可以保证可见性
    private static AtomicInteger num = new AtomicInteger(0);
    private volatile static int num0 = 0;
    public static  void add(){
        num.getAndIncrement();
    }
    //test1验证volatile保证可见性
    @Test
    public void test1() {
        new Thread(()->{
            while (num0==0){}  //线程1 对主内存（方法区）的变化是不知道的
        }).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        num0 = 1;
        System.out.println(num0);
    }
    //test2验证volatile不保证原子性，使用原子类解决原子性问题
    @Test
    public void test2(){
        for (int i = 1; i <=20; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            }).start();
        }
        while (Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+" "+num);
    }
}
