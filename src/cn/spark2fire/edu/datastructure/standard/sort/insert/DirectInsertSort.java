package cn.spark2fire.edu.datastructure.standard.sort.insert;

import cn.spark2fire.edu.datastructure.util.DataUtil;

/**
 * 改进方案, 改进
 */
/**
 * Author: Leon@spark2fire.cn
 * QQ Group: 493306318
 * Date: 2021/10/17
 */
 public class DirectInsertSort {
    /**
     * 核心思想是, 默认0是已经排好序了, 然后从1开始取
     * 取出来的数从后往前比较，找到正确位置就交换
     */
    public Integer[] sort(Integer[] array) {
        // 这个非核心
        if (array.length <= 1) {
            return array;
        }

        /**
         * 两次for, 第一次
         */
        for (int i = 1; i < array.length; i++) {
            // i以前就是已经排好序了, 现在要将第i个数的数插入

            // insert保存了第i个值
            Integer insert = array[i];
            // j要单独保留下来
            int j;
            // j从i-1开始
            for (j = i - 1; j >= 0; j--) {
                // 插入的数比array[j]大或相等, 就break
                if (insert >= array[j]) {
                    break;
                } else {
                    array[j + 1] = array[j];
                }
            }
            // j+1的位置是空出来的,必须写在循环外, 因为要考虑到插入的值比这一轮所有的值都小, j为-1
            array[j + 1] = insert;
        }
        return array;
    }

    // 备用的方法
    public Integer[] another(Integer[] input) {
        if (input.length <= 1) {
            return input;
        }

        Integer insertData;
        int idx;
        for (int i = 1; i < input.length; i++) {
            insertData = input[i];
            idx = i - 1;
            // 其实也可以用for循环，记住一定要从后往前
            while (idx >= 0 && insertData < input[idx]) {
                input[idx + 1] = input[idx];
                idx--;
            }
            if (idx + 1 != i) {
                input[idx + 1] = insertData;
            }
        }
        return input;
    }

    public static void main(String[] args) {
        int size = 20;
        int range = 100;
        Integer[] data = DataUtil.genUniqueArray(size, range);
        DataUtil.printIndex(size);
        DataUtil.printArray(data);
        DirectInsertSort insert = new DirectInsertSort();
        DataUtil.printArray(insert.sort(data));
    }
}
