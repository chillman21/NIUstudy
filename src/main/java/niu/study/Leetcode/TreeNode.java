package niu.study.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
        TreeNode() {}

    public static TreeNode createTree(Object[] nums) {
        List<TreeNode> datas = new ArrayList<>();//存储所有节点
        for (Object num : nums) {
            if (num!=null)
            datas.add(new TreeNode(Integer.parseInt(num.toString())));
            else datas.add(null);
        }
        TreeNode root = datas.get(0);//将第一个作为根节点
        for (int i = 0; i < nums.length / 2; i++) {
            datas.get(i).left = datas.get(2 * i + 1);
            if (2 * i + 2 < nums.length) {//避免偶数的时候，下标越界
                datas.get(i).right = datas.get(2 * i + 2);
            }
        }
        return root;
    }

}
