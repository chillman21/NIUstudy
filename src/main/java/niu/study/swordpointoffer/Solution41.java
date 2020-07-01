package niu.study.swordpointoffer;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution41 {
    class MedianFinder {
        //A的长度 >= B的长度
        Queue<Integer> A, B;
        public MedianFinder() {
            A = new PriorityQueue<>(); // 小顶堆，保存较大的一半
            B = new PriorityQueue<>((o1, o2) -> o2 - o1); // 大顶堆，保存较小的一半
        }
        public void addNum(int num) {
            if(A.size() != B.size()) {
                A.add(num);
                B.add(A.poll());
            } else {
                B.add(num);
                A.add(B.poll());
            }
        }
        public double findMedian() {
            return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
        }
    }
}
