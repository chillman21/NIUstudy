package niu.study.swordpointoffer;

import java.util.ArrayList;
import java.util.List;

public class Solution62 {
    /**
     * 约瑟夫环问题数学公式
     */
    public int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx = 0;
        while (n > 1) {
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }
}
