package niu.study.thread.JUC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者和消费者 等待唤醒、通知唤醒
 * 线程交替进行 A B 操作同一个变量 num=0
 * A num+1
 * B num-1
 */
public class ProducerAndConsumer3 {
    public static void main(String[] args) {
        Data3 data3 = new Data3();
        new Thread(()->{ for (int i = 0; i < 10; i++) { data3.printA();} },"A").start();
        new Thread(()->{ for (int i = 0; i < 10; i++) { data3.printB();} },"B").start();
        new Thread(()->{ for (int i = 0; i < 10; i++) { data3.printC();} },"C").start();
    }
}

//等待，业务，通知
class Data3{//资源类
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();
    //+1
    public void printA(){
        lock.lock();
        try {
            while (number!=1){
                //等待
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName()+"-->"+"AAAA");
            //通知其他线程，+1完毕了
            number = 2;
            condition2.signal();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
    public void printB(){
        lock.lock();
        try {
            while (number!=2){
                //等待
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName()+"-->"+"BBBBB");
            //通知其他线程，+1完毕了
            number = 3;
            condition3.signal();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
    public void printC(){
        lock.lock();
        try {
            while (number!=3){
                //等待
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName()+"-->"+"CCCCC");
            //通知其他线程，+1完毕了
            number = 1;
            condition1.signal();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }


}