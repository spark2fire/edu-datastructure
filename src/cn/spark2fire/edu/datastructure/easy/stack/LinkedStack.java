package cn.spark2fire.edu.datastructure.easy.stack;

/**
 * @author Leon@spark2fire.cn
 * @date 2021/5/6
 */
/**
 * Author: Leon@spark2fire.cn
 * QQ Group: 493306318
 * Date: 2021/10/17
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

    public static void main(String[] args) {
        LinkedStackNode node1 = new LinkedStackNode("a");
        LinkedStackNode node2 = new LinkedStackNode("b");
        LinkedStackNode node3 = new LinkedStackNode("c");
        LinkedStackNode node4 = new LinkedStackNode("d");

        LinkedStack stack = new LinkedStack();
        stack.push(node1);
        stack.push(node2);
        stack.push(node3);
        stack.push(node4);

        System.out.println(stack.top().data);
        System.out.println(stack.pop().data);
        System.out.println(stack.top().data);

    }
}
