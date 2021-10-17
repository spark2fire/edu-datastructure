package cn.spark2fire.edu.datastructure.standard.sort.insert;

import cn.spark2fire.edu.datastructure.util.DataUtil;

/**
 * Author: Leon@spark2fire.cn
 * QQ Group: 493306318
 * Date: 2021/10/17
 */
 public class BinaryInsertSort {

    public Integer[] sort(Integer[] array) {
        int low;
        int high;
        int mid;
        for (int i = 1; i < array.length; i++) {
            Integer insertNode = array[i];

            low = 0;
            // 目的就一个, 找到最后一个insert大的high坐标
            high = i - 1;

            // 这个是<=
            while (low <= high) {
                mid = (low + high) / 2;
                if (array[mid] > insertNode) {
                    // 这里是 mid - 1, 因为 mid已经比insert大了, 不然会死循环
                    high = mid - 1;
                } else {
                    // 应该是mid+1, 不然会死循环
                    low = mid + 1;
                }
            }

            // 记住是i-1
            for (int j = i - 1; j > high; j--) {
                array[j + 1] = array[j];
            }

            // 记住这里是high + 1
            array[high + 1] = insertNode;
        }
        return array;
    }

    public static void main(String[] args) {
        int size = 20;
        int range = 50;
        Integer[] data = DataUtil.genArray(size, range);
        DataUtil.printIndex(size);
        DataUtil.printArray(data);
        BinaryInsertSort insert = new BinaryInsertSort();
        DataUtil.printArray(insert.sort(data));
    }
}
