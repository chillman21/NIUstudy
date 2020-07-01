package niu.study.thread;

/**
 * 解决线程安全问题
 */
public class TicketDemo01 {
    public static void main(String[] args) {
        RunnableImpl runnable = new RunnableImpl();
        Thread t0 = new Thread(runnable);
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        //调用start
        t0.start();
        t1.start();
        t2.start();
    }
}
