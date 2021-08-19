package cn.spark2fire.edu.datastructure.standard.stack;

/**
 * Created by Leon@cn.spark2fire
 * Date: 2021/8/20.
 * QQ Group: 493306318
 */
public interface StackADT {
    int size();

    boolean isEmpty();

    // 获得栈顶, 但是不删除栈顶元素
    Object peek();
    // 压栈
    void push();
    // 出栈
    Object pop();
}