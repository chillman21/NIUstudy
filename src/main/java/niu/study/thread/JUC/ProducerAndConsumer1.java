package niu.study.thread.JUC;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ProducerAndConsumer1 {
    public static void main(String[] args) {
        IQueue queue = new IQueue(10);
        ExecutorService executorService1 = Executors.newFixedThreadPool(5);
        ExecutorService executorService2 = Executors.newFixedThreadPool(5);
        IntStream.range(0, 5).forEach(i -> executorService2.execute(new Consumer(queue)::processMsg));
        IntStream.range(0, 5).forEach(i -> executorService1.execute(new Producer(queue)::produceMsg));

        executorService1.shutdown();
        executorService2.shutdown();

    }
}
// 消息队列
class IQueue {
    static private final Object lock = new Object();

    Queue<String> queue;
    int maxSize;

    public IQueue(int size) {
        queue = new LinkedList<>();
        this.maxSize = size;
    }

    public void put(String msg) {
        synchronized (lock) {
            while (queue.size() == maxSize) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            queue.offer(msg);

            lock.notifyAll();
        }
    }

    public String take() {
        synchronized (lock) {
            try {
                while (queue.size() == 0) {
                    lock.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String res = queue.poll();
            lock.notifyAll();
            return res;
        }
    }
}

// 生产者
class Producer {
    IQueue queue;

    public Producer(IQueue queue) {
        // register queue
        this.queue = queue;
    }

    void produceMsg() {
        while (true) {
            String msg = "" + (int)(Math.random()*10);
            System.out.println(Thread.currentThread().getName() + "产生新消息:" + msg);
            queue.put(msg);
        }
    }
}

// 消费者
class Consumer {
    IQueue queue;

    public Consumer(IQueue queue) {
        // register queue
        this.queue = queue;
    }

    void processMsg() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + "拿到了新消息，正在处理：" + queue.take());
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
