package niu.study.swordpointoffer;

import niu.study.Leetcode.ListNode;

public class Solution52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA, l2 = headB;
        if (headA == null || headB == null) {
            return null;
        }
        while (l1 != l2) {
            l1 = (l1 == null) ? headB : l1.next;
            l2 = (l2 == null) ? headA : l2.next;
        }
        return l1;
    }
}
