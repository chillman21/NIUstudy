package niu.study.Leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        while (cur != null && count < k) {
            cur = cur.next;
            count++;
        }
        if (count == k) {
            cur = reverseKGroup(cur, k);
            while (count > 0) {
                count--;
                ListNode tmp = head.next;
                head.next = cur;
                cur = head;
                head = tmp;
            }
            head = cur;
        }
        return head;
    }

    public static void main(String[] args) {
        Solution25 solution25 = new Solution25();
        int[] array = {3,9,8,7,5};
        ListNode head = ListNode.setListNode(array);
        ListNode node = solution25.reverseKGroup(head, 3);
        while(node != null){
            System.out.print(node.val+"->");
            node = node.next;
        }
    }
}

