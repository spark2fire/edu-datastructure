package cn.spark2fire.edu.datastructure.easy.stack;

/**
 * @author Leon@spark2fire.cn
 * @date 2021/5/6
 */
public interface Stack<T> {
    boolean push(T node);
    T pop();
    T top();
}
