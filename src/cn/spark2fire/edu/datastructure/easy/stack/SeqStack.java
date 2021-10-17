package cn.spark2fire.edu.datastructure.easy.stack;

/**
 * @author Leon@spark2fire.cn
 * @date 2021/5/6
 */
/**
 * Author: Leon@spark2fire.cn
 * QQ Group: 493306318
 * Date: 2021/10/17
 */
 public class SeqStack {
    //只有数组是默认可以用的
    private SeqStackNode[] array;
    private int size;
    private int top;

    public SeqStack() {
        this.size = 50;
        array = new SeqStackNode[size];
        top = -1;
    }

    public SeqStack(int size) {
        this.size = size;
        array = new SeqStackNode[size];
        top = -1;
    }

    boolean push(SeqStackNode node) {
        if (size - 1 > top) {
            array[++top] = node;

            return true;
        } else {
            return false;
        }
    }

    SeqStackNode pop() {
        if (top >= 0) {
            return array[top--];
        }
        return null;
    }

    SeqStackNode top() {
        if (top >= 0) {
            return array[top];
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
