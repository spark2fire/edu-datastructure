package cn.spark2fire.edu.datastructure.easy.stack;

/**
 * @author Leon@spark2fire.cn
 * @date 2021/5/6
 */
public class LinkedStack {

    private LinkedStackNode lastNode = null;

    boolean push(LinkedStackNode node) {
        if (lastNode == null) {
            lastNode = node;
            lastNode.prev = null;
        } else {
            LinkedStackNode tempNode = lastNode;
            lastNode = node;
            lastNode.prev = tempNode;
        }
        return true;
    }

    LinkedStackNode pop() {
        if (lastNode != null) {
            LinkedStackNode tempNode = lastNode;
            lastNode = lastNode.prev;
            return tempNode;
        } else {
            return null;
        }
    }

    LinkedStackNode top() {
        return lastNode;
    }
}
