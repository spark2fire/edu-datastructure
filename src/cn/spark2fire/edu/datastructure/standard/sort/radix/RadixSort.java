package cn.spark2fire.edu.datastructure.standard.sort.radix;

import cn.spark2fire.edu.datastructure.standard.queue.Queue;
import cn.spark2fire.edu.datastructure.util.DataUtil;

/**
 * 基数排序又叫桶排序, 核心思想是
 * 建立queue桶
 */
/**
 * Author: Leon@spark2fire.cn
 * QQ Group: 493306318
 * Date: 2021/10/17
 */
 public class RadixSort {

    // 直接得到最大数字位数
    public Integer[] sort(Integer[] input, int d) {
        for (int i = 0; i < d; i++) {
            radixSort(input, i); // 执行 digit 次 bucketSort 排序即可
        }
        return input;
    }

    public void radixSort(Integer[] array, int digit) {
        // 除数值
        int divisor = (int) Math.pow(10, digit);

        // init buckets
        Queue<Integer>[] buckets = new Queue[10];
        for (int i = 0; i < 10; i++) {
            buckets[i] = new Queue<>(array.length);
        }
        // 都要从0开始
        for (int i = 0; i < array.length; i++) {
            // 记住这里, 一个除法的坑
            int index = (array[i] / divisor) % 10;
            buckets[index].enQueue(array[i]);
        }

        // 把桶里的数据倒出来
        int index = 0;
        for (int i = 0; i < 10; i++) {
            while (!buckets[i].isEmpty()) {
                array[index++] = buckets[i].deQueue();
            }
        }
    }

    public int getMaxDigit(int[] arr) {
        int digit = 1; // 默认只有一位
        int base = 10; // 十进制每多一位，代表其值大了10倍
        for (int i : arr) {
            while (i > base) {
                digit++;
                base *= 10;
            }
        }
        return digit;
    }

    public static void main(String[] args) {
        RadixSort radix = new RadixSort();
        int size = 20;
        int range = 999;
        Integer[] array = DataUtil.genUniqueArray(size, range);
        DataUtil.printIndex(size);
        DataUtil.printArray(array);
        DataUtil.printArray(radix.sort(array, 3));
    }

}
