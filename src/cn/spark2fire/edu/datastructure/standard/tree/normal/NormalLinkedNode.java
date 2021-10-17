package cn.spark2fire.edu.datastructure.standard.tree.normal;

import cn.spark2fire.edu.datastructure.standard.tree.binary.BinLinkedNode;

/* Binary
 * Linked
 * left child
 * right sibling
 */
/**
 * Author: Leon@spark2fire.cn
 * QQ Group: 493306318
 * Date: 2021/10/17
 */
 public class NormalLinkedNode {
    public Integer data;
    public NormalLinkedNode child;
    public NormalLinkedNode sibling;

    public NormalLinkedNode(Integer value) {
        data = value;
        child = null;
        sibling = null;
    }

    public BinLinkedNode transferToBin() {
        BinLinkedNode left = null;
        BinLinkedNode right = null;
        if (child != null) {
            left = child.transferToBin();
        }
        if (sibling != null) {
            right = sibling.transferToBin();
        }
        BinLinkedNode node = new BinLinkedNode(data);
        node.leftChild = left;
        node.rightChild = right;
        return node;
    }

    public NormalLinkedNode getFirstChild() {
        return child;
    }

    public NormalLinkedNode getChild(Integer value) {
        NormalLinkedNode node = child;
        while (node != null) {
            if (node.data == value) {
                return node;
            } else {
                node = node.sibling;
            }
        }
        return null;
    }

    // 常见考点, 可用于求树的高度, 和节点的深度
    public int getDepth() {
        if (child == null) {
            return 1;
        } else {
            if (child.sibling != null) {
                return child.getDepth() > child.sibling.getDepth() ? child.getDepth() + 1 : child.sibling.getDepth() + 1;
            } else {
                return child.getDepth() + 1;
            }
        }
    }

    public NormalLinkedNode addChild(NormalLinkedNode newNode) {
        if (child == null) {
            child = newNode;
            return child;
        } else {
            NormalLinkedNode currentChild = child;
            NormalLinkedNode lastChild = currentChild;
            while (currentChild != null) {
                lastChild = currentChild;
                currentChild = currentChild.sibling;
            }
            lastChild.sibling = newNode;
            return lastChild.sibling;
        }
    }


    public void visit() {
        System.out.println(this.data);
    }
}
