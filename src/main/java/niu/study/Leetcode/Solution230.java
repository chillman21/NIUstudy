package niu.study.Leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class Solution230 {
    public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) return arr;
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
        return arr;
    }

    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>());
        return nums.get(k - 1);
    }

    public int kthSmallest2(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();//此时root为最左根节点
            k--;
            if (k == 0) return root.val;
            root = root.right;
        }
    }

    public static void main(String[] args) {
        Solution230 solution230 = new Solution230();
        Object[] nums = {3,1,4,null,2};
        TreeNode root = TreeNode.createTree(nums);
        System.out.println(solution230.kthSmallest2(root,2));
    }

}
