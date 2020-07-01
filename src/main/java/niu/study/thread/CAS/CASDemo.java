package niu.study.thread.CAS;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * CAS : compareAndSet:比较并交换
 *
 * 注意：如果泛型是包装类，注意对象的引用问题
 */
public class CASDemo {
    static AtomicStampedReference<Integer> atomicInteger = new AtomicStampedReference<>(1,1);

    public static void main(String[] args) {
        //AtomicInteger atomicInteger = new AtomicInteger(2020);
        new Thread(()->{
            int stamp = atomicInteger.getStamp();//获得版本号
            System.out.println("a1=>"+stamp);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicInteger.compareAndSet(1, 2,
                    atomicInteger.getStamp(), atomicInteger.getStamp() + 1));
            System.out.println("a2=>"+atomicInteger.getStamp());
            System.out.println(atomicInteger.compareAndSet(2, 1,
                    atomicInteger.getStamp(), atomicInteger.getStamp() + 1));
            System.out.println("a3=>"+atomicInteger.getStamp());
        },"a").start();


        new Thread(()->{
            int stamp = atomicInteger.getStamp();//获得版本号
            System.out.println("b1=>"+stamp);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("b线程"+atomicInteger.compareAndSet(1, 6,
                    stamp, stamp + 1));
            System.out.println("b2=>"+atomicInteger.getStamp());
        },"b").start();
        /*
        源码：
        //如果我期望的值达到了，那么就更新，否则，就不更新
        //CAS是CPU的并发原语！
        public final boolean compareAndSet(int expectedValue, int newValue) {
        return U.compareAndSetInt(this, VALUE, expectedValue, newValue);
        }
        缺点：
        1.循环会耗时
        2.一次性只能保证一个共享变量的原子性
        3.会存在ABA问题

        */
//        atomicInteger.compareAndSet(2020,2021);
//        System.out.println(atomicInteger.get());
    }
}
