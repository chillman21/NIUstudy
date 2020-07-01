package niu.study.Leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution20 {
    private Map<Character, Character> map;
    public Solution20() { //使用空参构造函数初始化map
        map = new HashMap<Character, Character>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {//字符为前括号
                stack.push(c);
            } else {//字符为后括号
                char top = stack.empty() ? '0' : stack.pop();
                if (top != map.get(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        System.out.println(solution20.isValid("[({})]"));
    }
}