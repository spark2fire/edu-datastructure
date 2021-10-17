package cn.spark2fire.edu.datastructure.standard.tree.binary;

import java.util.List;

/**
 * Author: Leon@spark2fire.cn
 * QQ Group: 493306318
 * Date: 2021/10/17
 */
 public class BinarySortNode {
    public Integer data;
    public BinarySortNode left;
    public BinarySortNode right;
    Integer[] array;

    public BinarySortNode(Integer data) {
        this.data = data;
    }

    public void addChild(BinarySortNode node) {
        if (node != null) {
            if (node.data < this.data) {
                if (left == null) {
                    left = node;
                } else {
                    left.addChild(node);
                }
            } else {
                if (right == null) {
                    right = node;
                } else {
                    right.addChild(node);
                }
            }
        }
    }

    public void inOrderTraversal() {
        if (left != null) {
            left.inOrderTraversal();
        }
        visit();
        if (right != null) {
            right.inOrderTraversal();
        }
    }

    public List<Integer> getArray(List<Integer> list) {
        if (left != null) {
            list = left.getArray(list);
        }

        list.add(data);
        if (right != null) {
            list = right.getArray(list);
        }
        return list;
    }

    private void visit() {
        System.out.println(data);
    }
}
