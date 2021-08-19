package cn.spark2fire.edu.datastructure.easy.tree.binary;

/**
 * @author Leon@spark2fire.cn
 * @date 2021/5/7
 */
public interface BinaryTree<T> {
    T getRoot();
    T getParent();
    T getLeftChild();
    T getRightChild();
}
