package cn.spark2fire.edu.datastructure.standard.tree.binary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * huffman核心:
 * #1 带权重
 * #2 只有叶子节点才是本来的节点
 * #3 如果本来有n个节点, 最后一共有2n-1个节点
 * #4 每次要排序
 */
/**
 * Author: Leon@spark2fire.cn
 * QQ Group: 493306318
 * Date: 2021/10/17
 */
 public class HuffmanTree {

    public List<HuffmanNode> nodes;

    public HuffmanTree(Integer[] dataArray) {
        nodes = new ArrayList<>();
        for (Integer data : dataArray) {
            HuffmanNode node = new HuffmanNode(data);
            nodes.add(node);
        }
    }

    public HuffmanTree(List<HuffmanNode> nodeArray) {
        this.nodes = nodeArray;
    }

    //==============core==================
    public HuffmanNode buildTree() {
        while (nodes.size() > 1) {
            //sort
            Collections.sort(nodes);
            // 取左右
            HuffmanNode left = nodes.get(0);
            HuffmanNode right = nodes.get(1);
            // 生成parent
            HuffmanNode parent = new HuffmanNode(left.data + right.data);
            parent.left = left;
            parent.right = right;
            // remove
            nodes.remove(left);
            nodes.remove(right);
            // add
            nodes.add(parent);
        }
        return nodes.get(0);
    }
}
