package niu.study.thread.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 手写阻塞队列
 * @author NIU
 * @createTime 2020/8/6 19:04
 */
public class BoundedBuffer {
    //队列容器
    private List<Integer> container = new ArrayList<>();
    private volatile int size;
    private volatile int capacity;
    private Lock lock = new ReentrantLock();
    //Condition
    private final Condition isNull = lock.newCondition();
    private final Condition isFull = lock.newCondition();

    BoundedBuffer(int cap) {
        this.capacity = cap;
    }

    /**
     * 添加方法
     *
     * @param data
     */
    public void add(int data) {
        try {
            lock.lockInterruptibly();
            while (container.size() == capacity) {
                System.out.println("queue is full");
                isFull.await();
            }
            size++;
            container.add(data);
            isNull.signal();
        } catch (InterruptedException e) {
            isFull.signal();
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 取出元素
     *
     * @return
     */
    public int take() {
        try {

            lock.lock();
            try {
                while (size == 0) {
                    System.out.println("阻塞队列空了");
                    isNull.await();
                }
            } catch (InterruptedException e) {
                isNull.signal();
                e.printStackTrace();
            }
            --size;
            int res = container.get(0);
            container.remove(0);
            isFull.signal();
            return res;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        lock.lock();
        System.out.println(lock.getHoldCount());
        lock.unlock();
        new Thread(()->{
            System.out.println(lock.tryLock());
            lock.unlock();
        }).start();

    }
}