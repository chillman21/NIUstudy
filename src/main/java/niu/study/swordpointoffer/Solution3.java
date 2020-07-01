package niu.study.swordpointoffer;

import java.util.HashSet;
import java.util.Set;

public class Solution3 {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans = -1;
        for (int num : nums) {
            if(!set.add(num)){
                ans = num;
                break;
            }
        }
        return ans;
    }
}
