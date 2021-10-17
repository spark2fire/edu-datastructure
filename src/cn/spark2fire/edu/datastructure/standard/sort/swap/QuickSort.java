package cn.spark2fire.edu.datastructure.standard.sort.swap;

import cn.spark2fire.edu.datastructure.util.DataUtil;

/*
 * 核心思想:
 * 如果脑中把数据排成一行, 找第一个数作为中间值, 小的在左边, 大的在右边
 */
/**
 * Author: Leon@spark2fire.cn
 * QQ Group: 493306318
 * Date: 2021/10/17
 */
 public class QuickSort {

    public Integer[] sort(Integer[] input, int type) {
        switch (type) {
            case 1:
                quicksortFromLow(input, 0, input.length - 1);
                break;
            case 2:
                quicksortFromMid(input, 0, input.length - 1);
            default:
                quicksortFromHigh(input, 0, input.length - 1);
        }
        return input;
    }

    /**
     * 中轴值选左边, 右边还是中间会出现不同的考题, 只记这一种, 其他推导
     *
     * 具体思路:
     * #1
     *
     * @param array
     * @param origLow
     * @param origHigh
     */
    public void quicksortFromLow(Integer[] array, int origLow, int origHigh) {
        // 千万别忘了刚开始的判断
        if (origLow < origHigh) {
            /*
            Part I: 保存low, high, pivot
            */
            // low和high要用于接下来递归, 不更改, 用临时变量来进行操作
            int low = origLow;
            int high = origHigh;

            //选一个数当中轴值, 对应的这个位置就空出来
            Integer pivot = array[low];

            /*
            Part II: 3个while实现以pivot为标准, 左小右大的排序
            */

            // 这里必须是low<high, 3次while里面都包含这个条件, 记住pivot不变
            while (low < high) {
                // 如果pivot是选的low端, 就从high端开始, 如果大于等于pivot，就继续找
                // 当while条件不满足时, 就已经找到了要替换的high
                while (low < high && array[high] >= pivot) {
                    high--;
                }
                // low是已经备份了的数据, 空出来的, 交换之后high空出来
                // 这个时候array[low]和array[high]是一样的值
                array[low] = array[high];

                // high值向左在靠, 现在low需要向右靠, 如果小于等于pivot，就继续找
                while (low < high && array[low] <= pivot) {
                    low++;
                }
                array[high] = array[low];
            }
            //找完了, 现在把pivot设置回去, 这个时候low和high是相等的，因为3次while一直在比较
            array[low] = pivot;

            /*
            Part III: 递归
            */
            // 这就是为什么需要保存原始的low和high, 因为对子表进行排序, 所以可以记录一个共有的array
            quicksortFromLow(array, origLow, low - 1); // 对低子表进行递归排序
            quicksortFromLow(array, low + 1, origHigh); // 对高子表进行递归排序
        }
    }

    // 不推荐
    public void quicksortFromHigh(Integer[] array, int origLow, int origHigh) {

        // 千万别忘了刚开始的判断
        if (origLow < origHigh) {
            /*
            Part I: 保存low, high, pivot
            */
            // low和high要用于接下来递归, 不更改, 用临时变量来进行操作
            int low = origLow;
            int high = origHigh;

            //选一个数当中轴值, 对应的这个位置就空出来
            Integer pivot = array[high];

            /*
            Part II: 3次while实现以pivot为标准, 左小右大的排序
            */

            // 这里必须是low<high, 3次while里面都包含这个条件, 记住pivot不变
            while (low < high) {
                // 如果pivot是选的high端, 就从low端开始, 如果小于等于pivot，就继续找
                // 当while条件不满足时, 就已经找到了要替换的high
                while (low < high && array[high] <= pivot) {
                    low++;
                }
                // high是已经备份了的数据, 空出来的, 交换之后low空出来
                // 这个时候array[low]和array[high]是一样的值
                array[high] = array[low];

                // low值向右靠, 现在high需要向左靠, 如果大于等于pivot，就继续找
                while (low < high && array[low] >= pivot) {
                    high--;
                }
                array[low] = array[high];
            }

            /*
            Part III: 递归
            */
            //找完了, 现在把pivot设置回去, 这个时候low和high是相等的，因为3次while一直在比较
            array[low] = pivot;
            // 这就是为什么需要保存原始的low和high, 因为对子表进行排序, 所以可以记录一个共有的array
            quicksortFromLow(array, origLow, low - 1); // 对低子表进行递归排序
            quicksortFromLow(array, low + 1, origHigh); // 对高子表进行递归排序
        }
    }

    public void quicksortFromMid(Integer[] array, int origLow, int origHigh) {
        if (origLow < origHigh) {
        /*
        Part I: 保存low, high, pivot
         */
            // low和high要用于接下来递归, 不更改, 用临时变量来进行操作
            int low = origLow;
            int high = origHigh;
            //pivot选中间, 所以需要记录下来
            int idx = (low + high) / 2;
            Integer pivot = array[(low + high) / 2];

        /*
        Part II: 3次while实现以pivot为标准, 左小右大的排序
         */
            // 这里必须是low<high, 3次while里面都包含这个条件, 记住pivot不变
            while (low < high) {
                // pivot在中间, 所以记住先左后右
                // 当while条件不满足时, 就已经找到了要替换的high
                while (low < high && array[high] >= pivot) {
                    high--;
                }
                // low是已经备份了的数据, 空出来的, 交换之后high空出来
                // 这个时候array[low]和array[high]是一样的值
                array[idx] = array[high];
                idx = high;

                // high值向左在靠, 现在low需要向右靠, 如果小于等于pivot，就继续找
                while (low < high && array[low] <= pivot) {
                    low++;
                }
                array[high] = array[low];
            }

        /*
        Part III: 递归
         */
            //找完了, 现在把pivot设置回去, 这个时候low和high是相等的，因为3次while一直在比较
            array[low] = pivot;
            // 这就是为什么需要保存原始的low和high
            quicksortFromLow(array, origLow, low - 1); // 对低子表进行递归排序
            quicksortFromLow(array, low + 1, origHigh); // 对高子表进行递归排序
        }
    }

    public static void main(String[] args) {
        int high = 30;
        Integer[] array1 = DataUtil.genArray(30, 50);
        Integer[] array2 = array1;
        Integer[] array3 = array1;
        array1[0] = 15;
        array1[high - 1] = 15;

        array1[high / 2] = 20;
        array1[high / 2 - 1] = 20;
        DataUtil.printIndex(high);
        DataUtil.printArray(array1);
        QuickSort quick = new QuickSort();
        quick.sort(array1, 1);
        DataUtil.printArray(array1);
        quick.sort(array2, 2);
        DataUtil.printArray(array2);
        quick.sort(array3, 3);
        DataUtil.printArray(array3);
    }
}
