package niu.study.Leetcode;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }
    public static ListNode setListNode(int[] lists) {
        ListNode headNode = null;
        ListNode node = null;
        System.out.println("正在插入，链表长度为："+lists.length+"----");
        for (int i = 0; i < lists.length; i++) {

            if(i==0){
                headNode = new ListNode(lists[0]);
                node = headNode;
                System.out.println(node.val);
            }
            else{
                node.next = new ListNode(lists[i]);
                System.out.println(node.next.val);
                node =node.next;
            }
        }
        System.out.println("插入结束**********");
        return  headNode;
    }
    public static ListNode selectListNode(ListNode headNode, int index) {
        ListNode node = headNode;
        for (int i = 0; i < index; i++) {
            node = node.next;
            if(node == null){
                System.err.println("最大索引为"+i);
                break;
            }
        }
        return node;
    }

    public static void main(String[] args) {
        int[] lists={4,1,8,4,5};
        ListNode headNode = setListNode(lists);
        ListNode node = headNode;
        while(node != null){
            System.out.print(node.val+"->");
            node = node.next;
        }
    }

}
