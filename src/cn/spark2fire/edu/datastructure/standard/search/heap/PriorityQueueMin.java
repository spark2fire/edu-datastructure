package cn.spark2fire.edu.datastructure.standard.search.heap;
// https://zhuanlan.zhihu.com/p/39615266

import cn.spark2fire.edu.datastructure.util.DataUtil;

/**
 * 优先队列也是一种队列，只不过不同的是，优先队列的出队顺序是按照优先级来的；
 * 在有些情况下，可能需要找到元素集合中的最小或者最大元素
 * 优先队列ADT来完成操作，优先队列ADT是一种数据结构，它支持插入和删除最小值操作（返回并删除最小元素）或删除最大值操作（返回并删除最大元素）；
 * <p>
 * 这些操作等价于队列的enQueue和deQueue操作，区别在于，对于优先队列，元素进入队列的顺序可能与其被操作的顺序不同，
 * 作业调度是优先队列的一个应用实例，它根据优先级的高低而不是先到先服务的方式来进行调度；
 * <p>
 * 如果最小键值元素拥有最高的优先级，那么这种优先队列叫作升序优先队列（即总是先删除最小的元素），
 * 类似的，如果最大键值元素拥有最高的优先级，那么这种优先队列叫作降序优先队列（即总是先删除最大的元素）；
 * 由于这两种类型时对称的，所以只需要关注其中一种，如升序优先队列；
 * <p>
 * ------------------------------------------------------------------
 * 优先队列ADT
 * 下面操作组成了优先队列的一个ADT；
 * <p>
 * 1.优先队列的主要操作 优先队列是元素的容器，每个元素有一个相关的键值；
 * <p>
 * insert(key, data)：插入键值为key的数据到优先队列中，元素以其key进行排序；
 * deleteMin/deleteMax：删除并返回最小/最大键值的元素；
 * getMinimum/getMaximum：返回最小/最大剑指的元素，但不删除它；
 * <p>
 * 2.优先队列的辅助操作
 * <p>
 * 第k最小/第k最大：返回优先队列中键值为第k个最小/最大的元素；
 * 大小（size）：返回优先队列中的元素个数；
 * 堆排序（Heap Sort）：基于键值的优先级将优先队列中的元素进行排序；
 * ------------------------------------------------------------------
 * <p>
 * 优先队列的应用
 * 数据压缩：赫夫曼编码算法；
 * 最短路径算法：Dijkstra算法；
 * 最小生成树算法：Prim算法；
 * 事件驱动仿真：顾客排队算法；
 * 选择问题：查找第k个最小元素；
 */
/**
 * Author: Leon@spark2fire.cn
 * QQ Group: 493306318
 * Date: 2021/10/17
 */
 public class PriorityQueueMin {

    // 虽然是一个数组, 其实是一个完全二叉树
    private Integer[] tree;

    // 从-1开始
    private int lastIdx = -1;

    public PriorityQueueMin() {
        // 如果是不断加入的元素, 就初始化一下
        tree = new Integer[100];
    }

    public PriorityQueueMin(Integer[] array) {
        // 用输入的array初始化
        tree = new Integer[100];
        lastIdx = array.length - 1;
        for (int i = 0; i <= lastIdx; i++) {
            tree[i] = array[i];
        }

        // 现在开始调整
        adjust();
    }

    public void insert(Integer data) {
        tree[++lastIdx] = data;
        if (lastIdx != 0) {
            siftUp(lastIdx);
        }
    }

    public int getSize() {
        return lastIdx + 1;
    }

    /**
     * 其实核心思想就是
     * #1 把新的节点加入到最后
     * #2 Up的意思是和自己的parent比, 如果parent比自己大, 则换上去，然后记录下一个位置
     * #3 下一个位置是找自己的parent
     */
    private void siftUp(int idx) {
        // 只要还有父节点(也就是不是根节点)
        // 注意
        // 这里getParent(0)得到是负数
        while (getParent(idx) >= 0) {
            // 如果自己比父节点还小
            if (tree[idx] < tree[getParent(idx)]) {
                // 交换
                Integer tempData = tree[idx];
                tree[idx] = tree[getParent(idx)];
                tree[getParent(idx)] = tempData;
                // tempLast往上继续
                idx = getParent(idx);
            } else {
                break;
            }
        }
    }


    /**
     * 三步:
     * 1# 最后一个和第一个互换
     * 2# 把最后一个给删除
     * 3# 从第一个开始siftDown
     */
    public Integer deleteMin() {
        // 得到最小值
        Integer min = tree[0];
        // 把最大的换上来, 删除最后一个
        tree[0] = tree[lastIdx];
        tree[lastIdx--] = null;

        // 从根开始siftDown
        siftDown(0);

        return min;
    }


    private void siftDown(int idx) {

        // 连左子树都没有, 就可以停了
        // 或者不是非叶子节点
        while (getLeft(idx) <= lastIdx) {
            // 只有左子树
            if (getRight(idx) > lastIdx) {
                if (tree[idx] > tree[getLeft(idx)]) {
                    // 交换父子节点
                    Integer tempData = tree[idx];
                    tree[idx] = tree[getLeft(idx)];
                    tree[getLeft(idx)] = tempData;

                    // 继续往下比较, 这里只有左子树
                    idx = getLeft(idx);
                } else {
                    break;
                }
            } else { // 左右子树都有
                // 得到更小的子树的值
                int childIdx = tree[getLeft(idx)] < tree[getRight(idx)] ? getLeft(idx) : getRight(idx);
                if (tree[idx] > tree[childIdx]) {
                    // 交换父子节点
                    Integer tempData = tree[idx];
                    tree[idx] = tree[childIdx];
                    tree[childIdx] = tempData;

                    // 继续往下比较, 这里只有左子树
                    idx = childIdx;
                } else {
                    break;
                }
            }
        }
    }


    /**
     * 从第一个非叶子节点开始调整 n/2 -1, 倒着来
     */
    private void adjust() {
        for (int i = (lastIdx + 1) / 2 - 1; i >= 0; i--) {
            siftDown(i);
        }
    }

    // 完全二叉树不记得关系就自己画图
    private int getParent(int idx) {
        return (idx - 1) / 2;
    }

    // 完全二叉树不记得关系就自己画图
    private int getLeft(int idx) {
        return 2 * idx + 1;
    }

    // 完全二叉树不记得关系就自己画图
    private int getRight(int idx) {
        return 2 * idx + 2;
    }

    // 顶上永远是最小的
    public Integer getMin() {
        return tree[0];
    }

    public static void main(String[] args) {
        PriorityQueueMin pg = new PriorityQueueMin();
        Integer[] array = DataUtil.genUniqueArray(15, 50);
        DataUtil.printArray(array);
        for (int i = 0; i < array.length; i++) {
            pg.insert(array[i]);
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(pg.deleteMin());
        }
    }
}
