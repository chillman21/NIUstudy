package niu.study.Leetcode;
/**
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 *
 * 题目描述：找到倒数第 k 个的元素。
 */

import niu.study.algorithm.sort.QuickSort;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution215 {
    public static void main(String[] args) {
        int k = 2;
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        Arrays.sort(nums);
        System.out.println(nums[nums.length - k]);

    }
    public static int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 小顶堆
        for (int val : nums) {
            pq.add(val);
            if (pq.size() > k)  // 维护堆的大小为 K
                //  获取并移除此队列的头
                pq.poll();
        }
        return pq.peek();//获取但不移除此队列的头
    }
    public static int findKthLargest2(int[] nums, int k) {
        QuickSort sort = new QuickSort();
        sort.quickSort(nums,0,nums.length-1);
        return nums[nums.length - k];
    }
}
