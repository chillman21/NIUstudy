package niu.study.Leetcode;

import java.util.List;

public class Solution0806 {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        hanota(A.size(), A, B, C);
    }

    //有三根柱子，A:盘子所在的柱子,B:辅助柱子，C:目的柱子，即最后把盘子放到这根柱子。
    private void hanota(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
        //如果A柱子只剩一个盘子，那么直接移动到C柱子即可
        if (n == 1) {
            removeTo(A, C);
            return;
        }
        //把A柱子上面的n-1个盘子，借助辅助柱子C，放到柱子B上
        hanota(n - 1, A, C, B);
        //此时A柱子剩下那个盘子是n个盘子中最大的那个，把他移动到C柱子上
        removeTo(A, C);
        //最后把刚才放在B柱子上的n-1个盘子，借助柱子A辅助，放到柱子C上
        hanota(n - 1, B, A, C);
    }

    private void removeTo(List<Integer> l1, List<Integer> l2) {
        l2.add(l1.remove(l1.size() - 1));
    }
}
