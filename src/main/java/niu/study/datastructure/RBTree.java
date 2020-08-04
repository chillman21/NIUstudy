package niu.study.datastructure;

import java.util.Scanner;

/**
 * @author NIU
 * @createTime 2020/8/4 15:37
 */
public class RBTree <K extends Comparable<K>, V> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    //红黑树的树根
    private RBNode root;

    public RBNode getRoot() {
        return root;
    }

    /**
     * 获取当前节点的父节点
     * @param node 当前节点
     */

    private RBNode parentOf(RBNode node) {
        if (node != null) {
            return node.parent;
        }
        return null;
    }

    private boolean isRed(RBNode node) {
        if (null != node) {
            return node.color == RED;
        }
        return false;
    }

    private boolean isBlack(RBNode node) {
        if (null != node) {
            return node.color == BLACK;
        }
        return false;
    }

    private void setRed(RBNode node) {
        if (node != null) {
            node.color = RED;
        }
    }
    private void setBlack(RBNode node) {
        if (node != null) {
            node.color = BLACK;
        }
    }

    public void inOrderPrint() {
        if (root != null) {
            inOrderPrint(root.left);
            System.out.println("key:" + root.key + ",value:" + root.value);
            inOrderPrint(root.right);
        }
    }
    public void inOrderPrint(RBNode root) {
        if (root != null) {
            inOrderPrint(root.left);
            System.out.println("key:" + root.key + ",value:" + root.value);
            inOrderPrint(root.right);
        }
    }

    /**
     * 左旋方法
     * 左旋示意图：左旋x节点
     *    p                   p
     *    |                   |
     *    x                   y
     *   / \         ---->   / \
     *  lx  y               x   ry
     *     / \             / \
     *    ly  ry          lx  ly
     *
     */
    public void leftRotate(RBNode x) {
        //1.将y的左子节点赋值给x的右边，并且把x设置为y的左子节点的父节点
        RBNode y = x.right;
        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }
        //2.将x的父节点（非空时）指向y，更新y的父节点为x的父节点
        if (x.parent != null) {
            y.parent = x.parent;

            if(x == x.parent.left) {
                x.parent.left = y;
            } else {
                x.parent.right = y;
            }
        } else {// 说明x为root节点
            this.root = y;
            y.parent = null;
        }
        //3.将y的左子节点指向x，更新x的父节点为y
        x.parent = y;
        y.left = x;

    }
    /**
     * 右旋方法
     * 右旋示意图：右旋y节点
     *
     *      p                       p
     *      |                       |
     *      y                       x
     *     / \          ---->      / \
     *    x   ry                  lx  y
     *   / \                         / \
     *  lx  ly                      ly  ry
     */
    private void rightRotate(RBNode y) {
        //1.将x的右子节点赋值给y的左子节点，并将y赋值给x右子节点的父节点（x右子节点非空时）
        RBNode x = y.left;
        y.left = x.right;
        if(x.right != null) {
            x.right.parent = y;
        }
        //2.将y的父节点p（非空时）赋值给x的父节点，同时更新p的子节点为x（左或右）
        x.parent = y.parent;
        if(y.parent != null) {
            if(y.parent.left == y) {
                y.parent.left = x;
            } else {
                y.parent.right = x;
            }
        } else {
            this.root = x;
            x.parent = null;
        }
        //3.将x的右子节点赋值为y，将y的父节点设置为x
        x.right = y;
        y.parent = x;
    }

    /**
     * 公开的插入方法
     * @param key
     * @param value
     */
    public void insert(K key, V value) {
        RBNode<K, V> node = new RBNode<>();
        node.setKey(key);
        node.setValue(value);
        //新节点一定是红色！
        node.setColor(RED);
        insert(node);
    }

    private void insert(RBNode node) {
        //1.找到插入的位置
        RBNode parent = null;
        RBNode x = this.root;
        while(x != null) {
            parent = x;
            //a > b 则返回 1，否则返回 -1 ，相等返回0
            int cmp = node.key.compareTo(parent.key);
            if (cmp < 0) {
                x = x.left;
            } else if(cmp == 0) {
                parent.setValue(node.value);
                return;
            } else {
                x = x.right;
            }
        }
        node.parent = parent;
        if (parent != null) {
            if(node.key.compareTo(parent.key) < 0) {
                parent.left = node;
            } else {
                parent.right = node;
            }
        } else {
            this.root = node;
        }
        //插入之后需要进行修复红黑树，让红黑树再次平衡。
            insertFixUp(node);
    }

    /**
     * 插入后修复红黑树平衡的方法
     *     |---情景1：红黑树为空树,将根节点染色为黑色
     *     |---情景2：插入节点的key已经存在，不需要处理
     *     |---情景3：插入节点的父节点为黑色，因为不影响黑平衡，不需要处理
     *
     *     情景4 需要咱们去处理
     *     |---情景4：插入节点的父节点为红色
     *          |---情景4.1：叔叔节点存在，并且为红色（父-叔 双红）
     *                      处理：将爸爸和叔叔染色为黑色，将爷爷染色为红色，并且再以爷爷节点为当前节点，
     *                      进行下一轮递归处理。
     *          |---情景4.2：叔叔节点不存在，或者为黑色，父节点为爷爷节点的左子树
     *               |---情景4.2.1：插入节点为其父节点的左子节点（LL情况）
     *                              处理：将爸爸染色为黑色，将爷爷染色为红色，然后以爷爷节点为根节点进行
     *                                  右旋，就完成了。
     *               |---情景4.2.2：插入节点为其父节点的右子节点（LR情况）
     *                              处理：以爸爸节点为根进行一次左旋，得到LL双红情况。
     *                                  然后指定爸爸节点为当前节点进行下一轮递归处理。
     *          |---情景4.3：叔叔节点不存在，或者为黑色，父节点为爷爷节点的右子树
     *               |---情景4.3.1：插入节点为其父节点的右子节点（RR情况）
     *                              处理：将爸爸染色为黑色，将爷爷染色为红色，然后以爷爷节点为根节点进行
     *                                  左旋，就完成了。
     *               |---情景4.3.2：插入节点为其父节点的左子节点（RL情况）
     *                              处理：以爸爸节点为根进行一次左旋，得到RR双红情况。
     *                                   然后指定爸爸节点为当前节点进行下一轮递归处理。
     */
    private void insertFixUp(RBNode node) {
        RBNode parent = parentOf(node);//爸爸
        RBNode gparent = parentOf(parent);//爷爷
        //进入情景4：插入节点的父节点非空，为红色
        if(parent != null && isRed(parent)) {
            //父节点是红色的，那么一定存在爷爷节点，因为根节点不可以是红色
            //父节点为爷爷节点的左子树
            if(parent == gparent.left) {
                RBNode uncle = gparent.right;
                //进入情境4.1：叔叔节点存在，并且为红色（父-叔 双红）
                //将父和叔染色为黑色，再将爷爷染红，并将爷爷设置为当前节点，进入下一次递归调整
                if(uncle != null && isRed(uncle)) {
                    setBlack(parent);
                    setBlack(uncle);
                    setRed(gparent);
                    insertFixUp(gparent);
                    return;
                }
                //进入情景4.2：叔叔节点不存在，或者为黑色，父节点为爷爷节点的左子树
                if(uncle == null || isBlack(uncle)) {
                    //进入情景4.2.2：插入节点为其父节点的右子节点（LR情况）=>
                    //左旋（父节点），当前节点设置为父节点，进入下一次循环
                    if(node == parent.right) {
                        leftRotate(parent);
                        insertFixUp(parent);
                        return;
                    }

                    //进入情景4.2.1：插入节点为其父节点的左子节点（LL情况）=>
                    //变色（父节点变黑，爷爷节点变红），右旋爷爷节点
                    if(node == parent.left) {
                        setBlack(parent);
                        setRed(gparent);
                        rightRotate(gparent);
                    }


                }
            } else {//父节点为爷爷节点的右子树
                RBNode uncle = gparent.left;
                //进入情景4.1：叔叔节点存在，并且为红色（父-叔 双红）
                //将父和叔染色为黑色，再将爷爷染红，并将爷爷设置为当前节点，进入下一次循环判断
                if(uncle != null && isRed(uncle)) {
                    setBlack(parent);
                    setBlack(uncle);
                    setRed(gparent);
                    insertFixUp(gparent);
                    return;
                }
                //进入情景4.3：叔叔节点不存在，或者为黑色，父节点为爷爷节点的右子树
                if(uncle == null || isBlack(uncle)) {
                    //情景4.3.2：插入节点为其父节点的左子节点（RL情况）
                    //右旋（父节点）得到RR情况，当前节点设置为父节点，进入下一次循环
                    if(node == parent.left) {
                        rightRotate(parent);
                        insertFixUp(parent);
                        return;
                    }
                    //进入情景4.3.1：插入节点为其父节点的右子节点（RR情况）=>
                    //变色（父节点变黑，爷爷节点变红），右旋爷爷节点
                    if(node == parent.right) {
                        setBlack(parent);
                        setRed(gparent);
                        leftRotate(gparent);
                    }
                }
            }
        }
        setBlack(this.root);
    }

    static class RBNode <K extends Comparable<K>, V> {
        private RBNode parent;
        private RBNode left;
        private RBNode right;
        private boolean color;
        private K key;
        private V value;

        public RBNode() {
        }

        public RBNode(RBNode parent, RBNode left, RBNode right, boolean color, K key, V value) {
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.color = color;
            this.key = key;
            this.value = value;
        }

        public RBNode getParent() {
            return parent;
        }
        public void setKey(K key) {
            this.key = key;
        }
        public void setValue(V value) {
            this.value = value;
        }

        public void setParent(RBNode parent) {
            this.parent = parent;
        }

        public void setLeft(RBNode left) {
            this.left = left;
        }

        public void setRight(RBNode right) {
            this.right = right;
        }

        public void setColor(boolean color) {
            this.color = color;
        }

        public RBNode getLeft() {
            return left;
        }

        public RBNode getRight() {
            return right;
        }

        public boolean isColor() {
            return color;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public static void main(String[] args) {

        RBTree<Integer, Object> rbt = new RBTree();
        //测试输入：ijkgefhdabc
        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入key:");
            Integer key = sc.nextInt();
            rbt.insert(key, null);
            TreeOperation.show(rbt.getRoot());
        }
    }

}
