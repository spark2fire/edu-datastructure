package cn.spark2fire.edu.datastructure.standard.sort.select;

import cn.spark2fire.edu.datastructure.util.DataUtil;

/**
 * Author: Leon@spark2fire.cn
 * QQ Group: 493306318
 * Date: 2021/10/17
 */
 public class SimpleSelectSort {
    public Integer[] sort(Integer[] input) {
        for (int i = 0; i < input.length - 1; i++) {
            Integer temp = input[i];
            int idx = i;
            int j = i + 1;
            for (; j < input.length; j++) {
                if (input[j] < temp) {
                    temp = input[j];
                    idx = j;
                }
            }
            if (idx != i) {
                input[idx] = input[i];
                input[i] = temp;
            }
        }
        return input;
    }

    public static void main(String[] args) {
        Integer[] data = DataUtil.genUniqueArray(20, 500);
        DataUtil.printIndex(20);
        DataUtil.printArray(data);
        SimpleSelectSort select = new SimpleSelectSort();
        DataUtil.printArray(select.sort(data));
    }
}
