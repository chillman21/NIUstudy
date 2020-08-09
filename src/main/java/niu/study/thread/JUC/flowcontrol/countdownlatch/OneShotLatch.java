package niu.study.thread.JUC.flowcontrol.countdownlatch;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 用AQS手撕一个线程协作器
 * @author NIU
 * @createTime 2020/8/7 22:56
 */
public class OneShotLatch {
    private final Sync sync = new Sync();

    public void await() {
        sync.acquireShared(0);
    }

    public void signal() {
        sync.releaseShared(0);
    }

    private class Sync extends AbstractQueuedSynchronizer {
        @Override
        protected int tryAcquireShared(int arg) {
            return (getState() == 1) ? 1 : -1;//定义state为1时不会加入阻塞队列
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            setState(1);
            return true;
        }
    }

    public static void main(String[] args) {
        OneShotLatch oneShotLatch = new OneShotLatch();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                String name = Thread.currentThread().getName();
                System.out.println(name + "尝试获取Latch");
                oneShotLatch.await();
                System.out.println("开闸放行，"+ name +"继续运行");
            }).start();
        }
        try {
            Thread.sleep(3000);
            oneShotLatch.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
