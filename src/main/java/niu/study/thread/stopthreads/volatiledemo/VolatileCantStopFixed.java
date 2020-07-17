package niu.study.thread.stopthreads.volatiledemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 演示用volatile的局限
 * 陷入阻塞时，volatile无法终止线程
 * 此例中，生产者的生产速度很快，消费者消费速度慢，就会出现阻塞队列满的情况，生产者会阻塞
 * 等待消费者进一步消费
 */
public class VolatileCantStopFixed {
    class Producer implements Runnable {
        BlockingQueue<Integer> storage;
        public volatile boolean canceled = false;
        public Producer(BlockingQueue<Integer> storage) {
            this.storage = storage;

        }

        @Override
        public void run() {
            int num = 0;
            try {
                while (num <= 100000 && !Thread.currentThread().isInterrupted()) {
                    if (num % 100 == 0) {
                        storage.put(num);
                        System.out.println(num + "是100的倍数，被放到仓库中");
                    }
                    num++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("生产者停止运行");
            }
        }
    }

    class Consumer{
        BlockingQueue<Integer> storage;
        public Consumer(BlockingQueue<Integer> storage) {
            this.storage = storage;
        }
        public boolean needMoreNums(){
            if (Math.random() > 0.95) {
                return false;
            }
            return true;
        }
    }
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> storage = new ArrayBlockingQueue<Integer>(10);
        VolatileCantStopFixed body = new VolatileCantStopFixed();
        Producer producer = body.new Producer(storage);
        Thread producerThread = new Thread(producer);
        producerThread.start();
        Thread.sleep(1000);
        Consumer consumer = body.new Consumer(storage);
        while (consumer.needMoreNums()) {
            System.out.println(consumer.storage.take() + "被消费了");
            Thread.sleep(100);
        }
        System.out.println("消费者不需要更多数据了");
        producerThread.interrupt();
    }
}


