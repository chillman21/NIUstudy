package niu.study.thread.interview;

/**
 * 两个线程交替打印A-Z（有锁版）
 *
 * @author NIU
 * @createTime 2020/7/28 16:51
 */
public class AlternatePrint3 {
    static char print = 'a';

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (args) { // 锁的名称
                while (print <= 'z') {
                    if ((print - 'a') % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + "--------" + print++);
                        args.notify();
                    } else {
                        try {
                            args.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (args) { // 锁的名称
                while (print <= 'z') {
                    if ((print - 'a') % 2 == 1) {
                        System.out.println(Thread.currentThread().getName() + "--------" + print++);
                        args.notifyAll();
                    } else {
                        try {
                            args.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
        // 以上方式是使用synchronize关键字实现的

    }
}
