package cn.spark2fire.edu.datastructure.standard.search.balancetree;
// 口诀 https://blog.csdn.net/jinking01/article/details/105986893
// 实现 https://blog.csdn.net/javazejian/article/details/53892797

/**
 * 先插入, 再旋转
 * Core#1, compute height
 * Core#2, rotate, 当前节点为失衡节点
 * Core#3, 插入节点
 * 讨论的都是三代节点, X节点，子节点，孙子节点
 * 1 在结点X的左孩子结点的左子树中插入元素LL, 右旋
 * 2 在结点X的左孩子结点的右子树中插入元素LR
 * 3 在结点X的右孩子结点的左子树中插入元素RL
 * 4 在结点X的右孩子结点的右子树中插入元素RR, 左旋
 */
/**
 * Author: Leon@spark2fire.cn
 * QQ Group: 493306318
 * Date: 2021/10/17
 */
 public class AVLNode {
    public Integer data;
    public AVLNode left;
    public AVLNode right;

    public AVLNode(Integer data) {
        this.data = data;
    }

    //Core#1, compute height
    public int getHeight() {
        int height;
        int leftHeight = 0;
        int rightHeight = 0;
        if (left != null) {
            leftHeight = left.getHeight();
        }
        if (right != null) {
            rightHeight = right.getHeight();
        }
        height = 1 + leftHeight > rightHeight ? leftHeight : rightHeight;
        return height;
    }

    public int getLeftHeight() {
        return left != null ? left.getHeight() : 0;
    }

    public int getRightHeight() {
        return right != null ? right.getHeight() : 0;
    }

    /**
     * Core#3, 插入节点
     */
    public void addNode(AVLNode node) {
        if (node.data < this.data) {
            if (left == null) {
                left = node;
            } else {
                left.addNode(node);
            }
        } else {
            if (right == null) {
                right = node;
            } else {
                right.addNode(node);
            }
        }

        if (getLeftHeight() - getRightHeight() == 2) {
            // L
            if (left.getLeftHeight() - left.getRightHeight() == 2) {
                // LL
                rightRotate();
            } else {
                // LR
                LR_Rotate();
            }
        }
        if (getRightHeight() - getLeftHeight() == 2) {
            // R
            if (right.getLeftHeight() - right.getRightHeight() == 2) {
                // RL
                RL_Rotate();
            } else {
                // RR
                leftRotate();
            }
        }
    }

    /**
     * 在结点X的左孩子结点的左子树中插入元素LL, 右旋, 现场画图最方便
     */
    public void rightRotate() {
        AVLNode tempNode = this;
        tempNode.left = this.left.right;
        this.data = left.data;
        this.left = left.left;
        this.right = tempNode;
    }

    /**
     * 在结点X的右孩子结点的右子树中插入元素RR, 左旋
     */
    public void leftRotate() {
        AVLNode tempNode = this;
        tempNode.right = this.right.left;
        this.data = right.data;
        this.left = tempNode;
        this.right = right.right;
    }

    /**
     * 在结点X的左孩子结点的右子树中插入元素LR
     * 先对子节点左旋, 在对自己右旋
     */
    public void LR_Rotate() {
        this.left.leftRotate();
        rightRotate();
    }

    /**
     * 在结点X的右孩子结点的左子树中插入元素RL
     * 先对子节点右旋, 在对自己左旋
     */
    public void RL_Rotate() {
        this.right.rightRotate();
        leftRotate();
    }

    public AVLNode delete(Integer data) {
        return null;
    }
}
