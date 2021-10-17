package cn.spark2fire.edu.datastructure.standard.list.vector;

/**
 * Created by Leon@cn.spark2fire
 * Date: 2021/8/19.
 * QQ Group: 493306318
 */

// 不要去继承之前那个VectorADT
/**
 * Author: Leon@spark2fire.cn
 * QQ Group: 493306318
 * Date: 2021/10/17
 */
 public class Vector {
    private DataNode[] vector;
    private int capacity;
    private int tail;

    public Vector(int capacity) {
        vector = new DataNode[capacity];
        this.capacity = capacity;
        tail = 0;
    }

    public DataNode[] getVector() {
        return vector;
    }

    public boolean isEmpty() {
        return tail <= 0;
    }

    public int size() {
        return tail;
    }

    public DataNode add(Integer data) {
        return addToTail(data);
    }

    public void update(int idx, Integer data) throws Exception {
        if (idx >= tail) {
            throw new Exception("Out of bound.");
        }
        vector[idx].data = data;
    }

    public DataNode deleteByIndex(int index) throws Exception {
        if (index >= tail) {
            throw new Exception("Out of bound.");
        }
        DataNode removal = vector[index];
        for (int i = index; i < tail; i++) {
            vector[i] = vector[i + 1];
        }
        tail--;
        vector[tail] = null;
        return removal;
    }

    private DataNode addFromHead(Integer data) {
        if (tail >= capacity) {
            extend();
        }
        for (int i = tail; i > 0; i--) {
            vector[i] = vector[i - 1];
        }
        DataNode newNode = new DataNode(data);
        vector[0] = newNode;
        return newNode;
    }

    private DataNode addToTail(Integer data) {
        if (tail >= capacity) {
            extend();
        }
        DataNode newNode = new DataNode(data);
        vector[tail++] = newNode;
        return newNode;
    }


    public DataNode deleteByValue(Integer value) {
        DataNode removal = null;
        int i = 0;
        for (i = 0; i < tail; i++) {
            if (vector[i].data.equals(value)) {
                removal = vector[i];
                break;
            }
        }
        if (i < tail) {
            for (; i < tail; i++) {
                vector[i] = vector[i + 1];
            }
        }
        return removal;
    }

    private void extend() {
        int newSize = capacity + capacity / 2;
        DataNode[] temp = new DataNode[newSize];
        if (capacity >= 0) System.arraycopy(vector, 0, temp, 0, capacity);
        vector = temp;
        this.capacity = newSize;
    }
}
