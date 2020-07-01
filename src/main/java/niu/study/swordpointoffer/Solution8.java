package niu.study.swordpointoffer;

public class Solution8 {
    public class TreeLinkNode{
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode parent = null;

        TreeLinkNode(int val){
            this.val = val;
        }
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode == null)
            return null;
        if(pNode.right != null){
            TreeLinkNode child = pNode.right;
            while(child.left != null){
                child = child.left;
            }
            return child;
        }
        while(pNode.parent != null){
            TreeLinkNode parent = pNode.parent;
            if (pNode == parent.left)
                return parent;
            pNode = parent;
        }
        return null;
    }


}
