package niu.study.swordpointoffer;

import java.util.HashMap;
import java.util.Map;

public class Solution48 {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < s.length(); j++) {
            char key = s.charAt(j);
            if (map.containsKey(key)) {
                i = Math.max(i ,map.get(key));
            }
            res = Math.max(res, j - i + 1);
            map.put(key, j + 1);
        }
        return res;
    }
}
