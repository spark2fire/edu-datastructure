package cn.spark2fire.edu.datastructure.standard.list.linked;

/**
 * Created by Leon@cn.spark2fire
 * Date: 2021/8/19.
 * QQ Group: 493306318
 */
public class CircularLinkedList {

    // 其实不算是头结点，算是链表浮标
    public LinkedNode cursor;

    // size很重要，不然没法遍历
    public int size;

    public CircularLinkedList() {
        cursor = new LinkedNode(null);
    }

    public void add(Integer input) {
        LinkedNode newNode = new LinkedNode(input);
        if (cursor.next == null) {
            cursor.next = newNode;
            newNode.next = newNode;
        } else {
            newNode.next = cursor.next.next;
            cursor.next.next = newNode;
            cursor.next = newNode;
        }
        size++;
    }

    public void delete(Integer input) {
        LinkedNode parent = cursor;
        for (int i = 0; i < size; i++) {
            if (parent.next.data == input) {
                break;
            } else {
                parent = parent.next;
            }
        }
        if (parent.next.data == input) {
            parent.next = parent.next.next;
            size--;
        } else {
            System.out.println("No such element : " + input);
        }
    }

    public int getSize() {
        return size;
    }
}
