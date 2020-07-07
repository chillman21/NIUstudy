package niu.study.swordpointoffer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution59_II {


    class MaxQueue {
        Queue<Integer> que;
        Deque<Integer> deq;
        public MaxQueue() {
            que = new LinkedList<>();  //队列：插入和删除
            deq = new LinkedList<>();  //双端队列：获取最大值
        }

        public int max_value() {
            return deq.size() > 0 ? deq.peekFirst() : -1;  //双端队列的队首为que的最大值
        }

        public void push_back(int value) {
            que.add(value);  //value入队
            while (!deq.isEmpty() && deq.peekLast() < value) {
                deq.removeLast();  //将deq队尾小于value的元素删掉
            }
            deq.addLast(value);  //将value放在deq队尾
        }

        public int pop_front() {
            int tmp = que.size() > 0 ? que.poll() : -1;  //获得队首元素
            if (!deq.isEmpty() && deq.peekFirst() == tmp) {
                deq.removeFirst();  //如果出队的元素是当前最大值，将deq的队首出队
            }
            return tmp;
        }
    }

}
