package niu.study.swordpointoffer;

import niu.study.Leetcode.TreeNode;

import java.util.LinkedHashMap;
import java.util.TreeMap;

public class Solution27 {
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null) return null;
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;
    }
}
