package niu.study.Leetcode;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public static ListNode setListNode(int[] lists) {
        ListNode headNode = null;
        ListNode node = null;
        System.out.println("正在插入，链表长度为：" + lists.length + "----");
        for (int i = 0; i < lists.length; i++) {

            if (i == 0) {
                headNode = new ListNode(lists[0]);
                node = headNode;
                System.out.println(node.val);
            } else {
                node.next = new ListNode(lists[i]);
                System.out.println(node.next.val);
                node = node.next;
            }
        }
        System.out.println("插入结束**********");
        return headNode;
    }

    public static ListNode selectListNode(ListNode headNode, int index) {
        ListNode node = headNode;
        for (int i = 0; i < index; i++) {
            node = node.next;
            if (node == null) {
                System.err.println("最大索引为" + i);
                break;
            }
        }
        return node;
    }

    public static void main(String[] args) {
        int[] lists = {4, 1, 8, 4, 5};
        ListNode headNode = setListNode(lists);
        ListNode node = headNode;
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
    }

//    private Runnable getTask() {
//        //上次从队列中 poll() 是否超时
//        boolean timedOut = false; // Did the last poll() time out?
//
//        for (; ; ) {
//            int c = ctl.get();
//            int rs = runStateOf(c);
//
//            // Check if queue empty only if necessary.
//            if (rs >= SHUTDOWN && (rs >= STOP || workQueue.isEmpty())) {
//                decrementWorkerCount();
//                return null;
//            }
//            //从名称中可以判断，工作的线程数
//            int wc = workerCountOf(c);
//
//            // Are workers subject to culling?  从这里开始，值得关注
//            //是否剔除 worker？核心线程是否超时或工作线程数大于核心线程数
//            // allowCoreThreadTimeOut：If false (default), core threads stay alive even when idle.If true, core threads use keepAliveTime to time out waitingfor work.
//            boolean timed = allowCoreThreadTimeOut || wc > corePoolSize;
//            //由于可能在这个过程中执行了 setMaximumPoolSize() 方法。
//            //（（如果工作线程数大于最大线程数）或者（上次从队列中 poll()是否超时 且 需要剔除工作线程））且（工作线程数大于 1 或 工作队列是空的）
//            if ((wc > maximumPoolSize || (timed && timedOut))
//                    && (wc > 1 || workQueue.isEmpty())) {
//                 if (compareAndDecrementWorkerCount(c))
//                    return null;
//                continue;
//            }
//
//            //poll() 和 take() 都可以从队列中获取任务出来。具体使用哪个方法根据 timed 来判断。take() 是没有就阻塞直到有，这里的 poll() 加了一个超时控制。
//            try {
//                Runnable r = timed ?
//                        workQueue.poll(keepAliveTime, TimeUnit.NANOSECONDS) :
//                        workQueue.take();
//                if (r != null)
//                    return r;
//                timedOut = true;
//            } catch (InterruptedException retry) {
//                timedOut = false;
//            }
//        }
//    }

}
