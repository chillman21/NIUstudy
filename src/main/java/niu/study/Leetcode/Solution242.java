package niu.study.Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 */
class Solution242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Solution242 solution242 = new Solution242();
        System.out.println(solution242.isAnagram("anagram", "nagaram"));
    }
}
