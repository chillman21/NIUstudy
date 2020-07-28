package niu.study.test;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author NIU
 * @createTime 2020/7/27 18:37
 */
public class ThreadPoolTest {
    public static void main(String[] args) {

        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(3,5,1, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(1));
        threadPool.execute(()->{
            System.out.println("1");
        });

        //优雅关闭线程池
        threadPool.shutdown(); // Disable new tasks from being submitted
        // 设定最大重试次数
        try {
            // 等待 60 s
            if (!threadPool.awaitTermination(60, TimeUnit.SECONDS)) {
                // 调用 shutdownNow 取消正在执行的任务
                threadPool.shutdownNow();
                // 再次等待 60 s，如果还未结束，可以再次尝试，或则直接放弃
                if (!threadPool.awaitTermination(60, TimeUnit.SECONDS))
                    System.err.println("线程池任务未正常执行结束");
            }
        } catch (InterruptedException ie) {
            // 重新调用 shutdownNow
            threadPool.shutdownNow();
        }
    }
}
