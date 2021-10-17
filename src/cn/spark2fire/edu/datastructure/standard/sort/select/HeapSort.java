package cn.spark2fire.edu.datastructure.standard.sort.select;

import cn.spark2fire.edu.datastructure.util.DataUtil;

/**
 * Author: Leon@spark2fire.cn
 * QQ Group: 493306318
 * Date: 2021/10/17
 */
 public class HeapSort {

    /**
     * 调整的方向是从右到左，从下往上
     * 如何在完全二叉树中找非叶子节点, length/2 -1, 往前都是非叶子节点
     */
    public Integer[] sort(Integer[] array) {
        // 得到最大堆
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            siftDown(array, i, array.length);
            System.out.println("i等于" + i);
            DataUtil.printArray(array);
        }

        // 下沉堆顶最大元素
        for (int i = array.length - 1; i > 0; i--) {
            // 交换
            Integer temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            // 调整
            siftDown(array, 0, i);
        }
        return array;
    }

    private int getLeft(int idx) {
        return 2 * idx + 1;
    }

    /**
     * 核心代码
     *
     * @param array  传入的数组(完全二叉树), 左子树2i+1, 右子树2i+2, 必须是0开始
     * @param idx      非叶子节点index
     * @param length 需要调整的长度(为了排序)
     *               <p>
     *               循环的换从i开始以下所有的数都变成堆
     *               if (2 * i + 1 < length) {
     *               if (2 * i + 2 < length && array[2 * i + 2] > array[2 * i + 1]) {
     *               array[i] = array[2 * i + 2];
     *               } else {
     *               array[i] = array[2 * i + 1];
     *               }
     *               }
     */
    public void siftDown(Integer[] array, int idx, int length) {
        Integer temp = array[idx];
        for (int i = getLeft(idx); i < length; i = getLeft(i) /*其实这里j和i都一样*/) {
            if (i + 1 < length && array[i + 1] > array[i]) {
                i = i + 1;
            }
            // temp在整个循环中一直为i的值
            if (array[i] > temp) {
                array[idx] = array[i];
                idx = i; // 子节点需要继续和temp比较
            } else {
                break;
            }
        }
        array[idx] = temp;
    }

    public static void main(String[] args) {
        HeapSort heap = new HeapSort();
        int size = 20;
        int range = 999;
        Integer[] array = DataUtil.genUniqueArray(size, range);
        DataUtil.printIndex(size);
        DataUtil.printArray(array);
        DataUtil.printArray(heap.sort(array));
    }
}
