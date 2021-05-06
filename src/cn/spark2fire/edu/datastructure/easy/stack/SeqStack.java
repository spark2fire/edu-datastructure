package cn.spark2fire.edu.datastructure.easy.stack;

/**
 * @author Leon@spark2fire.cn
 * @date 2021/5/6
 */
public class SeqStack {
    //只有数组是默认可以用的
    private SeqStackNode[] array;
    private int size;
    private int lastIdx;

    public SeqStack() {
        this.size = 50;
        array = new SeqStackNode[size];
        lastIdx = -1;
    }

    public SeqStack(int size) {
        this.size = size;
        array = new SeqStackNode[size];
        lastIdx = -1;
    }

    boolean push(SeqStackNode node) {
        if (size - 1 > lastIdx) {
            array[++lastIdx] = node;

            return true;
        } else {
            return false;
        }
    }

    SeqStackNode pop() {
        if (lastIdx >= 0) {
            return array[lastIdx--];
        }
        return null;
    }

    SeqStackNode top() {
        if (lastIdx >= 0) {
            return array[lastIdx];
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
