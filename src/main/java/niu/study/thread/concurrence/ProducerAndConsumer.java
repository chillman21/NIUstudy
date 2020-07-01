package niu.study.thread.concurrence;

/**
 * 生产者和消费者 等待唤醒、通知唤醒
 * 线程交替进行 A B 操作同一个变量 num=0
 * A num+1
 * B num-1
 */
public class ProducerAndConsumer {
    public static void main(String[] args) {
        Data data = new Data();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();
    }
}
//等待，业务，通知
class Data{//资源类
    private int number = 0;

    //+1
    public synchronized void increment() throws InterruptedException {
        while (number!=0){
            //等待
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName()+"-->"+number);
        //通知其他线程，+1完毕了
        this.notifyAll();
    }
    public synchronized void decrement() throws InterruptedException {
        while (number==0){
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName()+"-->"+number);
        //通知其他线程，-1完毕了
        this.notifyAll();

    }


}