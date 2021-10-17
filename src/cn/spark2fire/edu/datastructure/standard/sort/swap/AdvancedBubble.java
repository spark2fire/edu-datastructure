package cn.spark2fire.edu.datastructure.standard.sort.swap;

import cn.spark2fire.edu.datastructure.util.DataUtil;

/**
 * Author: Leon@spark2fire.cn
 * QQ Group: 493306318
 * Date: 2021/10/17
 */
 public class AdvancedBubble {
    public Integer[] sort(Integer[] input) {
        int count = 0;
        boolean changed = false;
        Integer temp;
        for (int i = input.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                // "<", from small to big
                if (input[j] > input[j + 1]) {
                    changed = true;
                    temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                }
            }
            if (!changed) {
                break;
            }
            changed = false;
            count++;
        }
        System.out.println("======================" + count + "=====================");
        return input;
    }

    public static void main(String[] args) {
        Integer[] data = DataUtil.genUniqueArray(20, 500);
        DataUtil.printIndex(10);
        DataUtil.printArray(data);
        AdvancedBubble bubble = new AdvancedBubble();
        DataUtil.printArray(bubble.sort(data));
    }
}
