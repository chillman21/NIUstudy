package niu.study.Leetcode;

import java.util.*;

public class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        // init heap 'the less frequent element first'
        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>((o1,o2)->map.get(o1)-map.get(o2));


        // 把前k个元素放入堆中
        for (int n: map.keySet()) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        // build output list
        int[] top_k = new int[k];
        for (int i = k-1; i >= 0; i--) {
            top_k[i]=heap.poll();
        }

        return top_k;
    }

    public static void main(String[] args) {
        Solution347 solution347 = new Solution347();
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println(Arrays.toString(solution347.topKFrequent(nums, 2)));
    }

}
