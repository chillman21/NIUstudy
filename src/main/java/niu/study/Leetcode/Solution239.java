package niu.study.Leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;

class Solution239 {
    ArrayDeque<Integer> deq = new ArrayDeque<Integer>();

    public void clean(int i, int k, int [] nums) {
        //i：原数组中的索引 k：窗口长度
        if (!deq.isEmpty() && deq.getFirst() == i - k)//此步相当于窗口的尾部移动，将不在窗口内的元素移除
            deq.removeFirst();//弹出队首元素
        while (!deq.isEmpty() && nums[i] > nums[deq.getLast()])
            //在数组的当前元素左边且小于当前元素的数，将其移除一定不改变后续最大值索引，因为已经存在更大的了。
            deq.removeLast();//移除比当前元素小的所有元素
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        //提升特殊情况下的性能
        int n = nums.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;

        int max_idx = 0;
        //窗口首次移动前
        for (int i = 0; i < k; i++) {
            clean(i, k, nums);
            deq.addLast(i);//队尾插入元素，每次插入前先移除掉比它小的
            if (nums[i] > nums[max_idx]) max_idx = i; //得出首个窗口的最大值所在的索引下标
        }
        int [] output = new int[n - k + 1]; //窗口数量为n-k+1
        output[0] = nums[max_idx];
        //窗口首次移动后
        for (int i  = k; i < n; i++) {
            clean(i, k,nums);
            deq.addLast(i);//队尾插入元素,每次插入前先移除掉比它小的和不在窗口内的
            output[i - k + 1] = nums[deq.getFirst()];//队首元素一定为最大元素，将其索引放入
        }
        return output;
    }
    public static void main(String[] args) {
        Solution239 solution239 = new Solution239();
        int[] ints = solution239.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println(Arrays.toString(ints));
    }



}

