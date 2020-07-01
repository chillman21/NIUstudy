package niu.study.swordpointoffer;

import niu.study.Leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution34 {
    ArrayList<List<Integer>> res = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum);
        return res;
    }
    public void recur(TreeNode root, int tar) {
        if(root == null) return;
        path.add(root.val);
        tar -= root.val;
        if(tar == 0 && root.left == null && root.right == null)
            res.add(new ArrayList<>(path));// 拷贝一个新链表
        recur(root.left, tar);
        recur(root.right, tar);
        path.remove(path.size() - 1);
    }
}
