package cn.spark2fire.edu.datastructure.example;

/**
 * @author Leon@spark2fire.cn
 * @date 2021/4/29
 */
public class Demo implements OneStructure {

    public LinkedNode root;

    @Override
    public void addNode(LinkedNode node) {
        if (root == null) {
            root = node;
        } else {
            root.nextNode = node;
        }
    }

    @Override
    public LinkedNode getNode(int idx) {
        LinkedNode result = root;
        for (int i = 0; i < idx; i++) {
            result = result.nextNode;
        }
        return result;
    }
}
