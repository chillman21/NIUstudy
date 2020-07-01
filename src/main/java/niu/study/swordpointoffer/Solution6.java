package niu.study.swordpointoffer;



import niu.study.Leetcode.ListNode;

import java.util.Stack;

public class Solution6 {
    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode cur = head;
        while(cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        int size = stack.size();
        int[] ans = new int[size];
        for(int i = 0; i<size; i++){
            ans[i] = stack.pop().val;
        }
        return ans;
    }
}
