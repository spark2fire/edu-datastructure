package cn.spark2fire.edu.datastructure.standard.tree.binary;

/**
 * Author: Leon@spark2fire.cn
 * QQ Group: 493306318
 * Date: 2021/10/17
 */
 public class BinLinkedNode {
    public Integer data;
    public BinLinkedNode leftChild;
    public BinLinkedNode rightChild;

    public BinLinkedNode(Integer value) {
        data = value;
    }

    public Integer getData() {
        return data;
    }

    public int getDepth() {
        if (leftChild == null && rightChild == null) {
            return 1;
        } else {
            int left = 0;
            int right = 0;
            if (leftChild != null) {
                left = leftChild.getDepth();
            }
            if (rightChild != null) {
                right = rightChild.getDepth();
            }
            return left > right ? left + 1 : right + 1;
        }
    }

    public int leafNum() {
        if (leftChild == null && rightChild == null) {
            return 1;
        }
        int a = 0;
        int b = 0;
        if (leftChild != null) {
            a = leftChild.leafNum();
        }
        if (rightChild != null) {
            b = rightChild.leafNum();
        }
        return a + b;
    }

    public int singleChild() {
        int a = 0;
        int b = 0;
        if (leftChild != null) {
            a = leftChild.singleChild();
        }
        if (rightChild != null) {
            b = rightChild.singleChild();
        }
        if ((leftChild == null && rightChild == null) || (leftChild != null && rightChild != null)) {
            return a + b;
        } else {
            return 1 + a + b;
        }
    }

    public BinLinkedNode getLeftChild() {
        return leftChild;
    }

    public BinLinkedNode getRightChild() {
        return rightChild;
    }

    public BinLinkedNode addLeftChild(BinLinkedNode leftChild) {
        this.leftChild = leftChild;
        return this.leftChild;
    }

    public BinLinkedNode addRightChild(BinLinkedNode rightChild) {
        this.rightChild = rightChild;
        return this.rightChild;
    }

    public void preOrderTraverse() {
        visit();
        if (this.leftChild != null) {
            this.leftChild.preOrderTraverse();
        }
        if (this.rightChild != null) {
            this.rightChild.preOrderTraverse();
        }
    }

    public void inOrderTraverse() {
        if (leftChild != null) {
            this.leftChild.inOrderTraverse();
        }
        visit();
        if (rightChild != null) {
            this.rightChild.inOrderTraverse();
        }
    }

    public void postOrderTraverse() {
        if (leftChild != null) {
            leftChild.visit();
        }
        if (rightChild != null) {
            rightChild.visit();
        }
        visit();
    }

    public void visit() {
        System.out.println(data);
    }
}
