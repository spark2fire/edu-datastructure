package cn.spark2fire.edu.datastructure.standard.stack;

/**
 * Author: Leon@spark2fire.cn
 * QQ Group: 493306318
 * Date: 2021/10/17
 */
 public class Stack<T> {

    private T[] array;
    private int top;

    public int size;

    public Stack() {
        array = (T[]) new Object[50];
        size = 0;
        top = -1;
    }

    public void push(T object) {
        array[++top] = object;
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        } else {
            T removal = array[top];
            array[top--] = null;
            size--;
            return removal;
        }
    }

    public T getTop() {
        return array[top];
    }

    public void traverse() {
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                System.out.print(array[i] + "   ");
            }
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
