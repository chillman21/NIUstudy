package niu.study.thread;

/**
 * 解决线程安全问题：同步代码块
 */
public class RunnableImpl implements Runnable{
    private int ticket = 100;
    //创建一个锁对象（多个线程共用一个锁对象）
    Object obj = new Object();

    @Override
    public void run() {
        synchronized (obj){
            while (ticket>0){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"-->正在卖"+ticket+"张票");
                ticket--;
            }
        }

    }
}
