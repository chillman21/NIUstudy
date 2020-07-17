package niu.study.thread.stopthreads.solution;

/**
 * 最佳实践catch住了InterruptException之后优先选择：
 *      在方法签名中抛出异常
 *      那么在run()就会强制try/catch
 */
public class RightWaysStopThreadInProduct implements Runnable{
    @Override
    public void run() {
        while (true) {
            System.out.println("go");
            try {
                throwInMethod();
            } catch (InterruptedException e) {
                //保存日志，停止程序
                System.out.println("保存日志");
                e.printStackTrace();
                break;

            }
        }
    }

    private void throwInMethod() throws InterruptedException {
            Thread.sleep(2000);

    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWaysStopThreadInProduct());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
