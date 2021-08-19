package cn.spark2fire.edu.datastructure.standard.list.vector;

/**
 * Created by Leon@cn.spark2fire
 * Date: 2021/8/19.
 * QQ Group: 493306318
 */

// 不要去继承之前那个VectorADT
public class Vector {
    private DataNode[] vector;
    private int size;
    private int tail;

    public Vector(int size) {
        vector = new DataNode[size];
        this.size = size;
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

    public DataNode deleteByIndex(int index) {
        if (index < tail) {
            DataNode removal = vector[index];
            for (int i = index; i < tail; i++) {
                vector[i] = vector[i + 1];
            }
            return removal;
        }
        return null;
    }

    private DataNode addFromHead(Integer data) {
        if (tail >= size) {
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
        if (tail >= size) {
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
            if (vector[i].data == value) {
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
        int newSize = size + size / 2;
        DataNode[] temp = new DataNode[newSize];
        for (int i = 0; i < size; i++) {
            temp[i] = vector[i];
        }
        vector = temp;
        this.size = newSize;
    }
}
