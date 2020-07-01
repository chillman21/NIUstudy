package niu.study.Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
       List<List<Integer>> list = new ArrayList<List<Integer>>();
       levelHelper(list,root,0);
       return list;
    }

    public void levelHelper(List<List<Integer>> list,TreeNode root,int height) {
       if (root == null)return;
       if (height>=list.size())list.add(new ArrayList<Integer>());
       list.get(height).add(root.val);
       levelHelper(list,root.left,height+1);
       levelHelper(list,root.right,height+1);
    }
    public static void main(String[] args) {
        Object[] tree = {3,9,20,null,null,15,7};
        TreeNode root = TreeNode.createTree(tree);
        Solution102 solution102 = new Solution102();
        System.out.println(solution102.levelOrder(root));
    }
}
