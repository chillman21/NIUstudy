package niu.study.Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(new Object[]{2,1,3});
        Solution94 solution94 = new Solution94();
        System.out.println(solution94.inorderTraversal(root));
    }
}
