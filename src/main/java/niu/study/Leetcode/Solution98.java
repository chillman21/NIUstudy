package niu.study.Leetcode;

import java.util.Stack;

public class Solution98 {
    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;

        int val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        if (! helper(node.right, val, upper)) return false;
        if (! helper(node.left, lower, val)) return false;
        return true;
    }

    public boolean isValidBST2(TreeNode root) {
        return helper(root, null, null);
    }
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        double pre = - Double.MAX_VALUE;
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (curr.val <= pre) return false;
            pre = curr.val;
            curr = curr.right;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(new Object[]{2,1,3});
        Solution98 solution98 = new Solution98();
        System.out.println(solution98.isValidBST(root));
    }
}
