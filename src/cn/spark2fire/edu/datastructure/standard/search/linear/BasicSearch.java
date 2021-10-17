package cn.spark2fire.edu.datastructure.standard.search.linear;

import cn.spark2fire.edu.datastructure.standard.sort.insert.ShellSort;
import cn.spark2fire.edu.datastructure.util.DataUtil;

/**
 * ASL的计算
 * ASL = 求和 Pi * Ci
 * Pi 代表查到第i个记录的概率，一般是1/n
 * Ci 代表需要进行比较的次数
 */
/**
 * Author: Leon@spark2fire.cn
 * QQ Group: 493306318
 * Date: 2021/10/17
 */
 public class BasicSearch {

    // ASL = (n+1)/2
    // O(n)
    public int sequenceSearch(Integer[] array, int n, Integer search) {
        for (int i = 0; i < n; i++) {
            if (array[i] == search) {
                return i;
            }
        }
        return -1;
    }

    // ASL = (n+1)/2 * log2n
    // O(log2n)
    // 前提是array是有序的
    public int binarySearch(Integer[] array, int low, int high, Integer search) {
        int mid;
        // 必须是小于等于
        // 必须是小于等于
        // 这有这里是小于等于
        while (low <= high) {
            mid = (low + high) / 2;
            if (array[mid] == search) {
                return mid;
            } else if (array[mid] < search) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 如果array里面有重复值，那么算法得到的index不一样
     */
    public static void main(String[] args) {
        Integer[] array = DataUtil.genUniqueArray(100, 200);
        BasicSearch basic = new BasicSearch();
        ShellSort shell = new ShellSort();
        array = shell.sort(array);
        int a = basic.sequenceSearch(array, array.length, 51);
        int b = basic.binarySearch(array, 0, array.length, 51);
        if (a != b) {
            System.out.println();
        }
    }
}
