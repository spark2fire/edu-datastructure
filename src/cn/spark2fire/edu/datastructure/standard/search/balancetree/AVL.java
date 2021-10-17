package cn.spark2fire.edu.datastructure.standard.search.balancetree;

/**
 * ADT
 * -------------------------------
 * init
 * destroy
 * search - 虽然二叉搜索树也可以，但其实平衡二叉树才是常用
 * insert - AVL的插入是难点
 * delete - BST的删除是难点
 * traverse - 中序遍历直接是排好序的
 * -------------------------------
 */
public interface AVL {
    // 查找
    AVLNode search(Integer value);

    // 插入
    void insert(AVLNode node);

    // 删除
    AVLNode delete(Integer data);
}
