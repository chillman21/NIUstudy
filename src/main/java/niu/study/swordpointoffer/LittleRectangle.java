package niu.study.swordpointoffer;

public class LittleRectangle {
    public int fib(int n) {
        if (n <= 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];//两种情况：横着一个矩形；竖着两个矩形。
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new LittleRectangle().fib(3));
    }
}
