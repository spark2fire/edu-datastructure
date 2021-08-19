package cn.spark2fire.edu.datastructure.standard.list.linked;

/**
 * Created by Leon@cn.spark2fire
 * Date: 2021/8/19.
 * QQ Group: 493306318
 */
public interface ListADT {
    int size();

    boolean isEmpty();

    void add(LinkedNode node);

    void deleteByValue(Integer value);

    void findByValue(Integer value);

    void update(Integer currentValue, Integer newValue);
}
