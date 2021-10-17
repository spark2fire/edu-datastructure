package cn.spark2fire.edu.datastructure.standard.list.vector;

/**
 * Created by Leon@cn.spark2fire
 * Date: 2021/8/20.
 * QQ Group: 493306318
 */
/**
 * Author: Leon@spark2fire.cn
 * QQ Group: 493306318
 * Date: 2021/10/17
 */
 public class LinkedStack {
    // 推荐用哨兵, 哨兵就是始终用一个没有数据的Node来做桩子
    LinkedStackNode head = new LinkedStackNode(null);

    public boolean isEmpty() {
        return head.next == null;
    }

    public void push(Integer data) {
        LinkedStackNode node = new LinkedStackNode(data);
        node.next = head.next;
        head.next = node;
    }

    public Integer pop() {
        if (head.next != null) {
            LinkedStackNode node = head.next;
            head.next = head.next.next;
            return node.data;
        }
        return null;
    }
}
