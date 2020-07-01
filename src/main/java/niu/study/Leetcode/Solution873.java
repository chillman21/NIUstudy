package niu.study.Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution873 {
    public int violence(int[] A) {
        int N = A.length;
        Set<Integer> S = new HashSet<>();
        for (int x: A) S.add(x);

        int ans = 0;
        for (int i = 0; i < N; ++i)
            for (int j = i+1; j < N; ++j) {
                int x = A[j], y = A[i] + A[j];
                int length = 2;
                while (S.contains(y)) {
                    // x, y -> y, x+y
                    int tmp = y;
                    y += x;
                    x = tmp;
                    ans = Math.max(ans, ++length);
                }
            }

        return ans >= 3 ? ans : 0;
    }
    public int lenLongestFibSubseq(int[] A) {
        int N = A.length;
        Map<Integer, Integer> index = new HashMap<>();
        //按照key为节点值，i为索引存入map
        for (int i = 0; i < N; ++i)
            index.put(A[i], i);
        //longest[i, j] 是结束在 [i, j] 的最长路径
        Map<Integer, Integer> longest = new HashMap<>();
        int ans = 0;

        for (int k = 0; k < N; ++k)
            for (int j = 0; j < k; ++j) {
                //查看预测的值是否存在
                int i = index.getOrDefault(A[k] - A[j], -1);//得到索引i
                if (i >= 0 && i < j) {
                    //如果存在longest[i, j]，且(i, j) 和 (j, k) 是连通的
                    //那么longest[j, k] = longest[i, j] + 1
                    int cand = longest.getOrDefault(i * N + j, 2) + 1;
                    longest.put(j * N + k, cand);
                    ans = Math.max(ans, cand);
                }
            }

        return ans >= 3 ? ans : 0;
    }

    public static void main(String[] args) {
        Solution873 solution873 = new Solution873();
        System.out.println(solution873.lenLongestFibSubseq(new int[]{2,4,5,6,7,8,11,13,14,15,21,22,34}));
    }
}
