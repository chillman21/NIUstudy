package niu.study.Leetcode;

import java.util.Stack;

public class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        int[] lists1 = {1,2,4};
        int[] lists2 = {1,3,4};
        ListNode headNode1 = ListNode.setListNode(lists1);
        ListNode headNode2 = ListNode.setListNode(lists2);
        Solution21 solution21 = new Solution21();
        ListNode listNode = solution21.mergeTwoLists(headNode1, headNode2);
        while(listNode != null){
            System.out.print(listNode.val+"->");
            listNode = listNode.next;
        }
        Stack stack=new Stack();
        stack.push(-1);
    }
}
