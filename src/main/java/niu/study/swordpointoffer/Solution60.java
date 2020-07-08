package niu.study.swordpointoffer;

public class Solution60 {
    public double[] twoSum(int n) {
        // dp ：n个骰子点数的和为s的排列情况
        int[][] dp = new int[n + 1][6 * n + 1];//行列都加1是为了空出0行0列
        double[] ans = new double[5 * n + 1];
        double all = Math.pow(6,n);
        for (int i = 1; i <= 6; i++)
            dp[1][i] = 1;
        for (int i = 1; i <= n; i++) { //i代表已经掷下i个骰子
            for (int j = i; j <= 6 * n; j++) { //j代表i个骰子的和
                for (int k = 1; k <= 6; k++) { //k 代表i-1个骰子掷下之前，第一个骰子的点数
                    dp[i][j] += (j >= k) ? dp[i - 1][j - k] : 0;
                    if(i == n)
                        ans[j - i] = dp[i][j] / all;
                }
            }
        }
        return ans;
    }

}
