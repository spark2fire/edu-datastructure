package cn.spark2fire.edu.datastructure.standard.sort.swap;

import cn.spark2fire.edu.datastructure.util.DataUtil;

/**
 * Author: Leon@spark2fire.cn
 * QQ Group: 493306318
 * Date: 2021/10/17
 */
 public class BubbleSort {
    public Integer[] sort(Integer[] input) {
        Integer temp;
        for (int i = input.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                // "<", from small to big
                if (input[j] > input[j + 1]) {
                    temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                }
            }
        }
        return input;
    }

    public static void main(String[] args) {
        Integer[] data = DataUtil.genUniqueArray(10, 200);
        DataUtil.printIndex(10);
        DataUtil.printArray(data);
        BubbleSort bubble = new BubbleSort();
        DataUtil.printArray(bubble.sort(data));
    }
}