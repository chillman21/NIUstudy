package niu.study.thread.SpinLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁,自定义版,使用CAS实现
 */
public class spinLockDemo {
    //引用类型Thread，默认expectedValue值为null
    AtomicReference<Thread> atomicReference = new AtomicReference<>();
    public void myLock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+"==>myLock");
        //自旋
        while(!atomicReference.compareAndSet(null,thread)){

        }
    }
    public void myUnlock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+"==>myUnlock");
        //解锁
        atomicReference.compareAndSet(thread,null);


    }

    public static void main(String[] args) throws InterruptedException {
        spinLockDemo lock = new spinLockDemo();
        new Thread(()->{
            lock.myLock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.myUnlock();
            }
        },"T1").start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(()->{
            lock.myLock();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.myUnlock();
            }
        },"T2").start();
    }
}
