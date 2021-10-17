package cn.spark2fire.edu.datastructure.standard.queue;

/**
 * Author: Leon@spark2fire.cn
 * QQ Group: 493306318
 * Date: 2021/10/17
 */
 public class Queue<E> {

    private int front;//队头一端，只允许删除

    private int rear;//队尾一端，只允许插入操作

    private int max_size = 50;

    private Object[] data;

    public Queue() {
        this(50);
    }

    public Queue(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("队列初始化失败，原因是：" + size);
        }
        this.max_size = size;
        front = rear = 0;
        data = new Object[max_size];
    }

    //判断是否为空
    public boolean isEmpty() {
        return rear == front ? true : false;
    }

    //入队
    public boolean enQueue(E e) {
        if (rear == max_size) {
            throw new RuntimeException("队列满了");
        } else {
            data[rear++] = e;
            return true;
        }
    }

    //返回队首元素,不删除元素
    public E getTop() {
        if (isEmpty()) {
            return null;
        }
        return (E) data[front];
    }

    //出队
    public E deQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        } else {
            E e = (E) data[front];
            data[front++] = null;
            return e;
        }
    }

    //长度
    public int length() {
        return rear - front;
    }
}
