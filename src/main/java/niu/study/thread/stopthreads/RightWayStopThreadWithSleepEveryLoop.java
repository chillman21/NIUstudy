package niu.study.thread.stopthreads;

/**
 * 如果在执行过程中，每次循环都会调用sleep或wait等方法，那么...
 */
public class RightWayStopThreadWithSleepEveryLoop implements Runnable{

    @Override
    public void run() {
        int num = 0;
        try {
            while (num <= 10000) {
                if (num % 100 == 0) {
                    System.out.println(num + "是100的倍数");
                }
                num++;
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("任务运行结束了");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadWithSleepEveryLoop());
        thread.start();
        Thread.sleep(3000);
        thread.interrupt();
    }
}
