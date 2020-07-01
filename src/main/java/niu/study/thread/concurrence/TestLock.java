package niu.study.thread.concurrence;

import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
    public static void main(String[] args) {
        TestLock2 testLock2 = new TestLock2();
        new Thread(testLock2).start();
        new Thread(testLock2).start();
        new Thread(testLock2).start();
    }
}
class TestLock2 implements Runnable{
    int tickNums =10;
    //定义lock锁
    private final ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        while(true){
            try {
                lock.lock();//加锁
                if (tickNums>0){
                    Thread.sleep(1000);
                    System.out.println(tickNums--);
                }else break;
            } catch (Exception e){
                throw new RuntimeException(e);
            }finally {
                //解锁
                lock.unlock();
            }
        }
    }
}
