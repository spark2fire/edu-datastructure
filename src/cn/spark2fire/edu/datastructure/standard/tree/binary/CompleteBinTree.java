package cn.spark2fire.edu.datastructure.standard.tree.binary;

import cn.spark2fire.edu.datastructure.util.DataUtil;

/**
 * 完全二叉树可以用于构建堆
 */
/**
 * Author: Leon@spark2fire.cn
 * QQ Group: 493306318
 * Date: 2021/10/17
 */
 public class CompleteBinTree {

    private CompleteTreeNode[] nodes;
    private int nextIdx = 0;

    public CompleteBinTree() {
        this.nodes = new CompleteTreeNode[50];
    }

    public CompleteBinTree(int size) {
        this.nodes = new CompleteTreeNode[size];
    }

    public int getSize() {
        return nextIdx;
    }

    public int getHeight() {
        int result = 0;
        int num = nextIdx;
        while (num > 0) {
            num = num / 2;
            result++;
        }
        return result;
    }

    public void add(Integer input) {
        nodes[nextIdx++] = new CompleteTreeNode(input);
    }

    // 一个具有n个节点的完全二叉树,其叶子节点的个数n0为: n/2 向上取整，或者(n+1)/2 向下取整
    public int leafNum() {
        // 这里需要注意
        if (nextIdx % 2 == 0) {
            return nextIdx / 2;
        } else {
            return nextIdx / 2 + 1;
        }
    }

    public CompleteTreeNode getLeftChild(int index) {
        return nodes[2 * index + 1];
    }

    public CompleteTreeNode getRightChild(int index) {
        return nodes[2 * index + 2];
    }

    public CompleteTreeNode getParent(int index) {
        if (index != 0) {
            return nodes[(index - 1) / 2];
        }
        return null;
    }

    public static void main(String[] args) {
        CompleteBinTree tree = new CompleteBinTree();
        Integer[] array = DataUtil.genArray(14, 50);
        DataUtil.printArray(array);
        for (int i = 0; i < array.length; i++) {
            tree.add(array[i]);
        }
        System.out.println("Height of Tree : " + tree.getHeight());
        System.out.println("Size of Tree : " + tree.getSize());
        System.out.println("Leaf number of Tree : " + tree.leafNum());
    }
}

class CompleteTreeNode {
    Integer data;

    public CompleteTreeNode(Integer data) {
        this.data = data;
    }
}
