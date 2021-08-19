package cn.spark2fire.edu.datastructure.standard.list.vector;

/**
 * Created by Leon@cn.spark2fire
 * Date: 2021/8/19.
 * QQ Group: 493306318
 */
// 写每个数据结构之前, 先想好接口
public interface VectorADT {
    void add(DataNode node);

    DataNode getByIndex(int i);

    void deleteByValue(Integer value);

    int size();

    boolean isEmpty();
}
