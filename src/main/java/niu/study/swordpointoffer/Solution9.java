package niu.study.swordpointoffer;

import java.util.Stack;

public class Solution9 {
    static class CQueue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;
        public CQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void appendTail(int value) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            stack1.push(value);
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }

        public int deleteHead() {
            if (stack1.isEmpty()) return -1;
            return stack1.pop();
        }
    }
    /**
     * Your CQueue object will be instantiated and called as such:
     * CQueue obj = new CQueue();
     * obj.appendTail(value);
     * int param_2 = obj.deleteHead();
     */
    public static void main(String[] args) {
        CQueue obj = new CQueue();
        obj.appendTail(2);
        int param_2 = obj.deleteHead();
        System.out.println(param_2);
    }
}
