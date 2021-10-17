package cn.spark2fire.edu.datastructure.standard.search.balancetree;

/**
 * ADT
 * -------------------------------
 * init
 * destroy
 * search - 二叉查找
 * insert
 * delete - BST的删除是难点
 * traverse - 中序遍历直接是排好序的
 * -------------------------------
 */
public interface BST {
    // 查找
    Integer search(Integer value);

    // 插入
    void insert(Integer data);

    // 删除
    boolean delete(Integer data);

    void traverse();
}
