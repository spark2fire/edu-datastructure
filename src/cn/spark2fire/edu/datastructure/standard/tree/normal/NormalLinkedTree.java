package cn.spark2fire.edu.datastructure.standard.tree.normal;

import cn.spark2fire.edu.datastructure.standard.tree.binary.BinLinkedNode;
import cn.spark2fire.edu.datastructure.standard.tree.binary.BinLinkedTree;
import cn.spark2fire.edu.datastructure.util.DataUtil;

/**
 * Author: Leon@spark2fire.cn
 * QQ Group: 493306318
 * Date: 2021/10/17
 */
 public class NormalLinkedTree {
    public NormalLinkedNode root;

    public NormalLinkedTree() {
        root = null;
    }

    public NormalLinkedTree(NormalLinkedNode node) {
        root = node;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public BinLinkedTree transferToBin() {
        BinLinkedTree tree = null;
        BinLinkedNode node;
        if (root != null) {
            node = root.transferToBin();
            tree = new BinLinkedTree(node);
        }
        return tree;
    }

    public int getHeight() {
        if (root == null) {
            return 0;
        } else {
            return root.getDepth();
        }
    }


    // Test
    public static void main(String[] args) {
        NormalLinkedNode root = new NormalLinkedNode(0);

        NormalLinkedNode nodeA1 = new NormalLinkedNode(DataUtil.genNumber(100));
        NormalLinkedNode nodeA2 = new NormalLinkedNode(DataUtil.genNumber(100));
        NormalLinkedNode nodeB1 = new NormalLinkedNode(DataUtil.genNumber(100));
        NormalLinkedNode nodeB2 = new NormalLinkedNode(DataUtil.genNumber(100));
        NormalLinkedNode nodeB3 = new NormalLinkedNode(DataUtil.genNumber(100));
        NormalLinkedNode nodeC1 = new NormalLinkedNode(DataUtil.genNumber(100));
        NormalLinkedNode nodeC2 = new NormalLinkedNode(DataUtil.genNumber(100));
        NormalLinkedNode nodeC3 = new NormalLinkedNode(DataUtil.genNumber(100));
        NormalLinkedNode nodeC4 = new NormalLinkedNode(DataUtil.genNumber(100));
        NormalLinkedNode nodeD1 = new NormalLinkedNode(DataUtil.genNumber(100));
        NormalLinkedNode nodeD2 = new NormalLinkedNode(DataUtil.genNumber(100));
        NormalLinkedNode nodeD3 = new NormalLinkedNode(DataUtil.genNumber(100));
        NormalLinkedNode nodeD4 = new NormalLinkedNode(DataUtil.genNumber(100));

        root.addChild(nodeA1);
        root.addChild(nodeA2);
        nodeA1.addChild(nodeB1);
        nodeA1.addChild(nodeB2);
        nodeA2.addChild(nodeB3);
        nodeB2.addChild(nodeC2);
        nodeB1.addChild(nodeC1);

        nodeB3.addChild(nodeC3);
        nodeB3.addChild(nodeC4);
        nodeC1.addChild(nodeD1);
        nodeC2.addChild(nodeD2);
        nodeC3.addChild(nodeD3);
        nodeC3.addChild(nodeD4);

        NormalLinkedTree tree = new NormalLinkedTree(root);
    }
}
