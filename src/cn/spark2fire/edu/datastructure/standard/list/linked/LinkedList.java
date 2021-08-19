package cn.spark2fire.edu.datastructure.standard.list.linked;

import java.util.Objects;

/**
 * Created by Leon@cn.spark2fire
 * Date: 2021/8/19.
 * QQ Group: 493306318
 */
public class LinkedList {
    // java没有指针概念, 所以如果head本身不存放内容，就是头结点
    private LinkedNode head = new LinkedNode(null);
    // 如果要使用尾插法, 就用tail
    private LinkedNode tail = new LinkedNode(null);

    private int size;

    public LinkedList() {
        head = new LinkedNode(null);
        tail = new LinkedNode(null);
        size = 0;
    }

    public void add(LinkedNode node) {
        addFromHead(node);
    }

    private void addFromHead(LinkedNode node) {
        if (head.next != null) {
            node.next = head.next;
        }
        head.next = node;
        size++;
    }

    public LinkedNode findByValue(Integer value) throws Exception {
        if (head.next == null) {
            throw new Exception("Cannot find the node.");
        }
        LinkedNode temp = head.next;
        while (temp != null) {
            if (temp.data.equals(value)) {
                break;
            }
            temp = temp.next;
        }
        return temp;
    }

    // 思考一下, 为什么是By value?
    public void deleteByValue(Integer value) throws Exception {
        if (head.next == null) {
            throw new Exception("Cannot find the node.");
        }
        // 不用头结点就会多判断
        LinkedNode temp = head.next;
        while (temp.next != null) {
            if (temp.next.data.equals(value)) {
                break;
            }
            temp = temp.next;
        }
        if (temp.next == null) {
            throw new Exception("Cannot find the node.");
        }
        temp.next = temp.next.next;
        size--;
    }

    public void update(Integer currentValue, Integer newValue) throws Exception {
        LinkedNode node = findByValue(currentValue);
        node.data = newValue;
    }

    private void addFromTail(LinkedNode node) {
        if (tail.next != null) {
            tail.next.next = node;
        }
        tail.next = node;
        size++;
    }
}
