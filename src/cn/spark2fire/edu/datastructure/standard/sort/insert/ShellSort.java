package cn.spark2fire.edu.datastructure.standard.sort.insert;

import cn.spark2fire.edu.datastructure.util.DataUtil;

/**
 * Author: Leon@spark2fire.cn
 * QQ Group: 493306318
 * Date: 2021/10/17
 */
 public class ShellSort {
    public Integer[] sort(Integer[] array) {
        // 记得有3次for循环, 最外面是步长, 里面是插入排序
        for (int step = array.length / 2; step > 0; step = step / 2) {
            // 这个其实就是直接插入法
            for (int i = 0 + step; i < array.length; i = i + step) {
                Integer insert = array[i];
                int j;
                for (j = i - step; j >= 0; j = j - step) {
                    if (insert > array[j]) {
                        break;
                    } else {
                        array[j + step] = array[j];
                    }
                }
                array[j + step] = insert;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int size = 20;
        int range = 100;
        Integer[] data = DataUtil.genUniqueArray(size, range);
        DataUtil.printIndex(size);
        DataUtil.printArray(data);
        ShellSort shell = new ShellSort();
        DataUtil.printArray(shell.sort(data));
    }
}
