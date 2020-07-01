package niu.study.Leetcode;

import java.util.*;

/**
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class Solution17 {
    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    List<String> output = new ArrayList<String>();

    public void backtrack(String combination, String next_digits) {
        //如果号码全抠没了，结束回溯
        if (next_digits.length() == 0) {
            //把字符串存进ArrayList
            output.add(combination);
        }
        // 没抠完 继续抠
        else {
            String digit = next_digits.substring(0, 1);//获得首个号码
            String letters = phone.get(digit);//获得号码对应的字母数组
            for (int i = 0; i < letters.length(); i++) {
                String letter = letters.substring(i, i + 1);//遍历每个字母
                backtrack(combination + letter, next_digits.substring(1));//抠去首个字符
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0) backtrack("", digits);
        return output;
    }
    public static void main(String[] args) {
        String digits = "23";
        Solution17 solution17 = new Solution17();
        List<String> strings = solution17.letterCombinations(digits);
        System.out.println(strings);

    }
}
