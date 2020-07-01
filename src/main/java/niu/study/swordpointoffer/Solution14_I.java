package niu.study.swordpointoffer;

public class Solution14_I {
    public int cuttingRope(int n) {
        // dp的含义为：下标作为长度n，值为长度n下的最大乘积
        if(n <= 3) return n-1;

        int[] dp = new int[n+1];
        //因为两米三米的绳子特殊，它们剪开来的乘积还没有它们本身大，所以先手动赋值
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for(int i = 4; i <= n; i++){//对长度超过4的绳子进行裁剪
            int ans = 0;
            for(int j = 1; j <= i - 1; j++){
                ans = Math.max(ans, dp[j] * (i - j));
            }
            dp[i] = ans;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution14_I solution14_i = new Solution14_I();
        System.out.println(solution14_i.cuttingRope(5));
    }

}
