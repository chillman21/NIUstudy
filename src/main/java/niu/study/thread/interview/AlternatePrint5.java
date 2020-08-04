package niu.study.thread.interview;

/**
 * 两个线程交替打印0~100的奇偶数 使用wait和notify
 *
 * @author NIU
 * @createTime 2020/7/28 16:51
 */
public class AlternatePrint5 {
    static int num = 0;
    private static final Object lock = new Object();


    public static void main(String[] args) {

        new Thread(() -> {
            while (num <= 100) {
                synchronized (lock) {
                    //拿到锁就打印
                    System.out.println(Thread.currentThread().getName() + "---" + num++);
                    lock.notify();
                    if (num <= 100) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, "偶数").start();
        new Thread(() -> {
            while (num < 100) {
                synchronized (lock) {
                    //拿到锁就打印
                    System.out.println(Thread.currentThread().getName() + "---" + num++);
                    lock.notify();
                    if (num <= 100) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, "奇数").start();

    }
}
