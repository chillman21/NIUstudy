package niu.study.swordpointoffer;

import niu.study.Leetcode.ListNode;

import static niu.study.Leetcode.ListNode.setListNode;

public class Solution22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow=head,fast=head;
        int t = 1;
        while (fast != null) {
            if (t > k) slow=slow.next;
            fast = fast.next;
            t++;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] lists={4,1,8,4,5};
        ListNode headNode = setListNode(lists);
        System.out.println(new Solution22().getKthFromEnd(headNode,2).val);
    }
}
