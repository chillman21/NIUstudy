package niu.study.swordpointoffer;

import java.util.Arrays;

public class Solution19{
    public boolean isMatch(String A, String B) {
        int m = A.length();
        int n = B.length();
        boolean[][] f = new boolean[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // 分成空正则和非空正则两种
                if (j == 0) {
                    f[i][j] = i == 0;
                } else {
                    // 非空正则分为两种情况 * 和 非*
                    if (B.charAt(j - 1) != '*') {
                        if (i >= 1 && (A.charAt(i - 1) == B.charAt(j - 1) || B.charAt(j - 1) == '.')) {
                            f[i][j] = f[i - 1][j - 1];
                        }
                    } else {
                        // 碰到 * 了，分为看和不看两种情况
                        // 不看
                        if (j >= 2) {
                            f[i][j] |= f[i][j - 2];
                        }
                        // 看
                        if (i >= 1 && j >= 2 && (A.charAt(i - 1) == B.charAt(j - 2) || B.charAt(j - 2) == '.')) {
                            f[i][j] |= f[i - 1][j];
                        }
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(f));
        return f[m][n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution19().isMatch("","a*"));
    }
}
