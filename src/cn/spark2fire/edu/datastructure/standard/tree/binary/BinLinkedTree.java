package cn.spark2fire.edu.datastructure.standard.tree.binary;

import cn.spark2fire.edu.datastructure.standard.queue.Queue;
import cn.spark2fire.edu.datastructure.util.DataUtil;

/**
 * Author: Leon@spark2fire.cn
 * QQ Group: 493306318
 * Date: 2021/10/17
 */
 public class BinLinkedTree {
    BinLinkedNode root;

    public BinLinkedTree() {
        root = null;
    }

    public BinLinkedTree(BinLinkedNode node) {
        root = node;
    }

    public int getDepth() {
        if (root == null) {
            return 0;
        }
        return root.getDepth();
    }

    public void preOrderTravese() {
        if (root != null) {
            root.preOrderTraverse();
        }
    }

    public void inOrderTraverse() {
        if (root != null) {
            root.inOrderTraverse();
        }
    }

    public void postOrderTraverse() {
        if (root != null) {
            root.postOrderTraverse();
        }
    }

    /**
     * 层次遍历是相对需要记忆的方法，而且这个遍历一般写在tree里面, 步骤是：
     * 1. 先创建一个队列
     * 2. 把根节点入队
     * 3. 每次出队的时候，就把出队的节点的左右子树入队
     * 4. 当队列为空时，遍历结束
     * <p>
     * 注意两种写法，一种是没有queue的简易写法，参看Quest05
     */
    public void levelTraverse() {
        Queue<BinLinkedNode> queue = new Queue<>(50);
        queue.enQueue(root);
        while (queue.length() > 0) {
            BinLinkedNode node = queue.deQueue();
            System.out.println(node.data);
            if (node.leftChild != null) {
                queue.enQueue(node.leftChild);
            }
            if (node.rightChild != null) {
                queue.enQueue(node.rightChild);
            }
        }
    }

    public int leafNum() {
        int count = 0;
        if (root != null) {
            count = root.leafNum();
        }
        return count;
    }

    public int singleChildNum() {
        int count = 0;
        if (root != null) {
            count = root.singleChild();
        }
        return count;
    }

    public static void main(String[] args) {
        BinLinkedNode root = new BinLinkedNode(0);
        System.out.println("root is " + root.data);

        BinLinkedNode nodeA1 = new BinLinkedNode(DataUtil.genNumber(100));
        BinLinkedNode nodeA2 = new BinLinkedNode(DataUtil.genNumber(100));
        BinLinkedNode nodeB1 = new BinLinkedNode(DataUtil.genNumber(100));
        BinLinkedNode nodeB2 = new BinLinkedNode(DataUtil.genNumber(100));
        BinLinkedNode nodeB3 = new BinLinkedNode(DataUtil.genNumber(100));
        BinLinkedNode nodeC1 = new BinLinkedNode(DataUtil.genNumber(100));
        BinLinkedNode nodeC2 = new BinLinkedNode(DataUtil.genNumber(100));
        BinLinkedNode nodeC3 = new BinLinkedNode(DataUtil.genNumber(100));
        BinLinkedNode nodeC4 = new BinLinkedNode(DataUtil.genNumber(100));
        BinLinkedNode nodeD1 = new BinLinkedNode(DataUtil.genNumber(100));
        BinLinkedNode nodeD2 = new BinLinkedNode(DataUtil.genNumber(100));
        BinLinkedNode nodeD3 = new BinLinkedNode(DataUtil.genNumber(100));
        BinLinkedNode nodeD4 = new BinLinkedNode(DataUtil.genNumber(100));
        BinLinkedNode nodeD5 = new BinLinkedNode(DataUtil.genNumber(100));

        root.addLeftChild(nodeA1);
        root.addRightChild(nodeA2);
        System.out.println("level 1 is " + nodeA1.data);
        nodeA1.addLeftChild(nodeB1);
        nodeA1.addRightChild(nodeB2);
        nodeA2.addLeftChild(nodeB3);
        System.out.println("level 2 is " + nodeB2.data);
        nodeB2.addRightChild(nodeC2);
        nodeB1.addLeftChild(nodeC1);
        nodeB3.addRightChild(nodeC3);
        nodeB3.addLeftChild(nodeC4);
        System.out.println("level 3 is " + nodeC1.data);
        nodeC1.addRightChild(nodeD1);
        nodeC2.addLeftChild(nodeD2);
        nodeC2.addRightChild(nodeD3);
        nodeC3.addLeftChild(nodeD4);
        nodeC3.addRightChild(nodeD5);
        System.out.println("level 3 is " + nodeD1.data);

        BinLinkedTree tree = new BinLinkedTree(root);
        tree.preOrderTravese();
        tree.inOrderTraverse();
        tree.postOrderTraverse();
        System.out.println("Leaf Num:" + tree.leafNum());
        System.out.println("Single child Num:" + tree.singleChildNum());
        System.out.println("Tree depth: " + tree.getDepth());
        tree.levelTraverse();
    }
}
