package niu.study.Leetcode;



import static niu.study.Leetcode.ListNode.selectListNode;
import static niu.study.Leetcode.ListNode.setListNode;

/**
 * Definition for singly-linked list.
 *
 */
public class Solution160 {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA, l2 = headB;
        if (headA == null || headB == null) return null;
        while (l1 != l2) {
            System.out.println("***********");
            l1 = (l1 == null) ? headB : l1.next;
//            if(l1==null) System.out.println("空节点");
//            else System.out.println(l1.val);
            l2 = (l2 == null) ? headA : l2.next;
//            if(l2==null) System.out.println("空节点");
//            else System.out.println(l2.val);
            System.out.println("---------------");
        }
        return l1;
    }

    public static void main(String[] args) {
        //intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
        ListNode listA = setListNode(new int[]{4,1,8,4,5});
        ListNode listB = setListNode(new int[]{5,0,1});
        selectListNode(listB,2).next = selectListNode(listA,2);
        ListNode intersectionNode = getIntersectionNode(listA, listB);
        System.out.println("交叉节点为："+intersectionNode.val);
        System.out.println(selectListNode(listA,4).val);

    }
}
