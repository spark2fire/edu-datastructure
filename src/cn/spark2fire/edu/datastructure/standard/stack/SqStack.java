package cn.spark2fire.edu.datastructure.standard.stack;

import java.util.Arrays;

/**
 * Created by Leon@cn.spark2fire
 * Date: 2021/8/20.
 * QQ Group: 493306318
 */
public class SqStack {
    int capacity = 50;
    int top = -1;

    Integer[] array = new Integer[capacity];

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    /**
     * @param data
     */
    public Integer push(Integer data) {
        if (top == capacity - 1) {
            extend();
        }
        array[++top] = data;
        return array[top];
    }

    public Integer pop() {
        Integer result = array[top];
        array[top--] = null;
        return result;
    }

    public Integer peek() {
        return array[top];
    }

    private void extend() {
        int newSize = capacity + capacity / 2;
        Integer[] temp = new Integer[newSize];
        System.arraycopy(array, 0, temp, 0, capacity);
        array = temp;
        capacity = newSize;
    }
}
