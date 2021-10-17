package cn.spark2fire.edu.datastructure.standard.list.linked;

/**
 * Created by Leon@cn.spark2fire
 * Date: 2021/8/19.
 * QQ Group: 493306318
 */
/**
 * Author: Leon@spark2fire.cn
 * QQ Group: 493306318
 * Date: 2021/10/17
 */
 public class DoubleLinkedList {

    // java没有指针概念, 所以如果head本身不存放内容，就是头结点, 现在多用头结点，方便
    public DoubleLinkedNode head;

    public int size;

    public DoubleLinkedList() {
        this.head = new DoubleLinkedNode();
    }

    public void add(Integer input) {
        DoubleLinkedNode newNode = new DoubleLinkedNode();
        newNode.data = input;
        if (head.next == null) {
            head.next = newNode;
            newNode.prev = head;
        } else {
            newNode.next = head.next;
            head.next.prev = newNode;
            newNode.prev = head;
            head.next = newNode;
        }
        size++;
    }

    public void delete(Integer input) {
        DoubleLinkedNode locator = head.next;
        while (locator != null) {
            if (locator.data == input) {
                break;
            } else {
                locator = locator.next;
            }
        }
        if (locator == null) {
            System.out.println("No such element : " + input);
        } else {
            locator.next.prev = locator.prev;
            locator.prev.next = locator.next;
            size--;
        }
    }

    public int getSize() {
        return size;
    }
}
