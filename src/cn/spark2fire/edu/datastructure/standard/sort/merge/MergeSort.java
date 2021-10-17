package cn.spark2fire.edu.datastructure.standard.sort.merge;

import cn.spark2fire.edu.datastructure.util.DataUtil;

/**
 * 二路归并排序核心思想: 分治法
 * 如果有两个已经排好序的数组, 现在想办法把它们合在一起
 * 于是可以递归
 *
 */
/**
 * Author: Leon@spark2fire.cn
 * QQ Group: 493306318
 * Date: 2021/10/17
 */
 public class MergeSort {
    Integer[] temp;

    public Integer[] sort(Integer[] array) {
        // temp的size一定要和array一致, 因为最后一次排序会正好满
        temp = new Integer[array.length];
        sort(array, 0, array.length - 1);
        return array;
    }

    private void sort(Integer[] arr, int left, int right) {
        // 这个条件记清楚, 一定是左小于右
        if (left < right) {
            // 不用纠结于mid的位置是否造成左右不一样多
            int mid = (left + right) / 2;
            sort(arr, left, mid);//左边归并排序，使得左子序列有序
            sort(arr, mid + 1, right);//右边归并排序，使得右子序列有序
            merge(arr, left, mid, right);//将两个有序子数组合并操作
        }
    }

    private void merge(Integer[] arr, int left, int mid, int right) {
        int i = left;//左序列开始位置
        int j = mid + 1;//右序列开始位置
        int t = 0;//temp从0开始

        /**
         * part I:这是核心部分, 其实也很简单, 就是下面的while
         */
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        while (i <= mid) {//将左边剩余元素填充进temp中
            temp[t++] = arr[i++];
        }
        while (j <= right) {//将右序列剩余元素填充进temp中
            temp[t++] = arr[j++];
        }

        // 将temp中的元素全部拷贝到原数组中
        t = 0;
        // 这就是为什么要保留原始left, right, 这样每次只需要把排好序的一部分复制就好了
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }

    public static void main(String[] args) {
        int size = 20;
        int range = 100;
        Integer[] data = DataUtil.genUniqueArray(size, range);
        DataUtil.printIndex(size);
        DataUtil.printArray(data);
        MergeSort merge = new MergeSort();
        DataUtil.printArray(merge.sort(data));
    }
}
