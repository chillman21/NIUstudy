package niu.study.Leetcode;

import java.util.Arrays;
import java.util.Stack;

public class Solution739 {
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];//初始化答案数组
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                Integer top = stack.pop();
                ans[top] = i - top;
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution739 solution739 = new Solution739();
        int[] array = solution739.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println(Arrays.toString(array));
    }

}
