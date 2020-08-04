package niu.study.thread.interview;

/**
 * 两个线程交替打印0~100的奇偶数 耗时版，只用syn，可能多次获取锁浪费时间，
 *
 * @author NIU
 * @createTime 2020/7/28 16:51
 */
public class AlternatePrint4 {
    static int num = 0;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            while (num < 100) {
                synchronized (lock) {
                    if ((num & 1) == 0) {
                        System.out.println(Thread.currentThread().getName() + "---" + num++);
                    }
                }
            }
        }).start();
        new Thread(() -> {
            while (num < 100) {
                synchronized (lock) {
                    if ((num & 1) == 1) {
                        System.out.println(Thread.currentThread().getName() + "---" + num++);
                    }
                }
            }
        }).start();

    }
}
