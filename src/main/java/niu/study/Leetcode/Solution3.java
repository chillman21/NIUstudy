package niu.study.Leetcode;

import java.util.*;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */

class Solution3 {
        public static int lengthOfLongestSubstring(String s) {
            int ans = 0;
            Map<Character, Integer> map = new HashMap<>();
            for (int j = 0, i = 0; j < s.length(); j++) {
                char key = s.charAt(j);
                if (map.containsKey(key)) {
                    i = Math.max(map.get(key), i);
                }
                ans = Math.max(ans, j - i + 1);
                map.put(key, j + 1);
            }
            return ans;
        }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abwcdabc"));
    }

}
