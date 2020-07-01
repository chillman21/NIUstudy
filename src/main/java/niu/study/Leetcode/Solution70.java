package niu.study.Leetcode;

public class Solution70 {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int a = 1, b = 2;
        int next = 0;
        for (int i = 3; i <= n; i++) {
            next = a + b;
            a = b;
            b = next;
        }
        return next;
    }

    public static void main(String[] args) {
        System.out.println(new Solution70().climbStairs(4));
    }
}
