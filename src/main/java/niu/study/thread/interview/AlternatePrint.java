package niu.study.thread.interview;

/**
 * 写两个线程，一个线程打印1~26，另一个线程打印字母A-Z，交替打印数字和字母
 * @author NIU
 * @createTime 2020/7/28 16:51
 */
public class AlternatePrint {
    static class PrintRunnable implements Runnable {
        //定义一个锁
        private Object lock;

        public PrintRunnable(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 26; i++) {
                    if ("打印数字".equals(Thread.currentThread().getName())) {
                        //打印数字1-26
                        System.out.print(i + 1);
                        // 唤醒其他在等待的线程
                        lock.notifyAll();
                        try {
                            // 让当前线程释放锁资源，进入wait状态
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else if ("打印字母".equals(Thread.currentThread().getName())) {
                        // 打印字母A-Z
                        System.out.print((char) ('A' + i));
                        // 唤醒其他在等待的线程
                        lock.notifyAll();
                        try {
                            // 让当前线程释放锁资源，进入wait状态
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
    //测试main方法
    public static void main(String[] args) {
        Object lock = new Object();
        new Thread(new PrintRunnable(lock), "打印数字").start();
        new Thread(new PrintRunnable(lock), "打印字母").start();
    }
}
