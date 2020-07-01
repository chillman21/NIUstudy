package niu.study.Leetcode;

import java.util.Arrays;
import java.util.Stack;

public class Solution32 {
//    public int longestValidParentheses(String s) {
//        List<Character> list = new ArrayList<>();
//        int count=0 ,i= 0;
//
//        while (s.charAt(i)=="(".charAt(0)&&s.charAt(i+1)==")".charAt(0)&&i<s.length()-1){
//            count ++;
//            i+=2;
//            list.add(s.charAt(i));
//            list.add(s.charAt(i+1));
//        }
//        return count;
//    }
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<Character>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push('(');//进栈
                } else if (!stack.empty() && stack.peek() == '(') {
                    stack.pop();//出栈
                } else {
                    return false;
                }
            }
            return stack.empty();
        }
        public int longestValidParentheses1(String s) {
            int maxans = 0;
            Stack<Integer> stack = new Stack<>();
            stack.push(-1);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push(i);
                } else {
                    stack.pop();
                    if (stack.empty()) {
                        stack.push(i);
                    } else {
                        maxans = Math.max(maxans, i - stack.peek());
                    }
                }
            }
            return maxans;
        }
    public int longestValidParentheses(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                }
                else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        System.out.println(Arrays.toString(dp));
        return maxans;
    }
    public static void main(String[] args) {
        Solution32 solution32 = new Solution32();
        System.out.println(solution32.longestValidParentheses1(")(())()()(()"));
    }
}
