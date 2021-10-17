package cn.spark2fire.edu.datastructure.standard.tree.binary;

/**
 * Author: Leon@spark2fire.cn
 * QQ Group: 493306318
 * Date: 2021/10/17
 */
 public class HuffmanNode implements Comparable<HuffmanNode> {
    public Integer data;
    public HuffmanNode left;
    public HuffmanNode right;

    public HuffmanNode(Integer data) {
        this.data = data;
    }

    public void preOrder() {
        visit();
        if (left != null) {
            left.preOrder();
        }
        if (right != null) {
            right.preOrder();
        }
    }

    public void inOrder() {
        if (left != null) {
            left.inOrder();
        }
        visit();
        if (right != null) {
            right.inOrder();
        }
    }

    private void visit() {
        // only handle leaf
        if (left == null && right == null) {
            System.out.println(data);
        } else {
            //not required
            System.out.println("---");
        }
    }

    @Override
    public int compareTo(HuffmanNode o) {
        // this is important
        return this.data - o.data;
    }
}
