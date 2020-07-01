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
public class ProducerAndConsumer2 {
    public static void main(String[] args) {
        Data2 data2 = new Data2();
        new Thread(()->{ for (int i = 0; i < 10; i++) { data2.increment();} },"A").start();
        new Thread(()->{ for (int i = 0; i < 10; i++) { data2.decrement();} },"B").start();
        new Thread(()->{ for (int i = 0; i < 10; i++) { data2.increment();} },"C").start();
        new Thread(()->{ for (int i = 0; i < 10; i++) { data2.decrement();} },"D").start();
    }
}

//等待，业务，通知
class Data2{//资源类
    private int number = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    //+1
    public  void increment(){
        lock.lock();
        try {
            while (number!=0){
                //等待
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName()+"-->"+number);
            //通知其他线程，+1完毕了
            condition.signalAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
    public void decrement(){
        lock.lock();
        try {
            while (number==0){
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName()+"-->"+number);
            //通知其他线程，-1完毕了
            condition.signalAll();

        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }


}