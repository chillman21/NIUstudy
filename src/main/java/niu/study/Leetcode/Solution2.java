package niu.study.Leetcode;

/*
示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]

 */
class Solution2 {
    public  static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }//构造方法，传参数用的
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(2);
        a1.next =new ListNode(4);
        a1.next.next=new ListNode(3);
        ListNode a2 = new ListNode(5);
        a2.next =new ListNode(6);
        a2.next.next =new ListNode(4);
        ListNode dummyHead=addTwoNumbers(a1,a2);
        System.out.println(dummyHead.val);
        System.out.println(dummyHead.next.val);
        System.out.println(dummyHead.next.next.val);

    }
}
