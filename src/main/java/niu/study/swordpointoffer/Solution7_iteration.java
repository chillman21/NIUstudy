package niu.study.swordpointoffer;

import niu.study.Leetcode.Solution94;
import niu.study.Leetcode.TreeNode;

import java.util.Stack;

public class Solution7_iteration {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int length = preorder.length;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < length; i++) {
            int preorderVal = preorder[i];//当前节点的值
            TreeNode node = stack.peek();//先序遍历的上一个节点(已存在栈中)
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }
    public static void main(String[] args) {
        Solution7_iteration iteration = new Solution7_iteration();
        TreeNode node = iteration.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(new Solution94().inorderTraversal(node));
    }
}
