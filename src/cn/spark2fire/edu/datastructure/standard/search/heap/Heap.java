package cn.spark2fire.edu.datastructure.standard.search.heap;

/**
 * 堆定义：（这里只讲二叉堆）堆实为二叉树的一种，分为最小堆和最大堆，具有以下性质：
 * <p>
 * 任意节点小于/大于它的所有后裔，最小/大元在堆的根上。
 * 堆总是一棵完全二叉树, 将根节点最大的堆叫做最大堆或大根堆，根节点最小的堆叫做最小堆或小根堆。
 * <p>
 * <p>
 * <p>
 * ···最小堆···
 * 《注意： 实际上并不需要用节点来真正构造一颗树，我们只是在数组中操作排序，调整好的数组就是一个堆的层遍历结果》
 * <p>
 * 插入：
 * 也是插入末尾，然后调整，调整也应该是一个连续向上的过程，建树就是一个连续插入的过程
 * <p>
 * 删除最小：
 * 即删除root：
 * 用末尾一个代替root，删除末尾，然后siftDown，如果子节点有更小的，每次只需要找到最小的子节点，然后交换即可。
 * <p>
 * siftDown: 调整
 * 先找到非叶子节点
 * 如果建树得以保证，那么如果子节点有更小的，每次只需要找到最小的子节点，然后交换即可。
 * 如果是一个乱的树，那么就要考虑，比较麻烦， 解决方式：
 * i 从 最后一个节点的父节点出开始迭代，直到 i = 0;
 * 每次检查时，将大的节点交换到末尾——就是要到底，如果大，就要成为叶节点，不是只交换一次（用循环）
 * <p>
 * 那么就有两种构建方法：
 * 1.乱序构建，调整（ 一个一个添加（从数组中），添加到最后一个，树的最右最下方的那个，然后siftUp,从下往上调整就可以了 ，O（log2（n）））
 * 2.一次一节点，依次调整
 *
 * <p>
 * 思考题： 设计算法检查一个完全二叉树是不是堆，是的话是最大堆还是最小堆。
 * 思路：元素1个，同为最大最小堆
 * 元素>1个：
 * 判断第一二个大小
 * 第一个大： 可能为最大堆，然后递归校验，如果每一个节点都比子节点大，那么是最大堆，否则不是堆
 * 第二个大： 可能为最小堆，然后递归校验，如果每一个节点都比子节点小，那么是最小堆，否则不是堆
 * <p>
 * <p>
 * 时间复杂度分析：
 * 建树：两种方式都是 O(nlog2(n))
 * 插入： O(log2(n))
 * 删除： O(log2(n))
 */


/**
 * Author: Leon@spark2fire.cn
 * QQ Group: 493306318
 * Date: 2021/10/17
 */
 public class Heap {
    private int[] data;
    private final int maxSize = 128;  //预设大小，足够就行
    private int size; //实际大小

    public Heap(int[] input) {
        data = new int[maxSize];
        size = input.length;
        for (int i = 0; i < size; i++) {//这个地方其实并不好，只是将传入的数组读入我的数组中，一方有不断插入操作，如果没有插入操作则不必要；
            data[i] = input[i];
        }
    }


    public void build_1() {
        /**
         * 建树方法1：
         *      每次插入一个节点
         */
        int a = size;
        size = 0;
        for (int i = 0; i < a; i++) {
            insert(data[i]);
        }
    }

    public void build_2() {
        /**
         * 建树方法2：
         *      以原来的乱序进行调整：siftDown
         */
        if (size <= 1) return;
        for (int i = getParent(size - 1); i >= 0; i--) {  // // 从最后一个非叶子节点开始，从后往前调整
            siftDown(i);
        }
    }

    /**
     * 由上而下调整， sift——筛
     *
     * @param start
     * start就是非叶子节点
     */
    public void siftDown(int start) {
        //start至少1子，不用担心溢出问题
        while (getLeftIdx(start) < size) {  //注意，这里必须是小于，不能等于，如果该节点的左节点是末尾节点则结束，条件是getLeft(start)==heapSize-1
            int min = 0;//判别有没有发生交换的条件, 一直到根节点
            //无右子
            if (getRightIdx(start) >= size) {
                /**
                 * 如果子节点反而比父节点小
                 * #1 记录子节点, 需要看子节点是否仍然需要交换
                 * #2 交换值
                 */
                if (data[start] > data[getLeftIdx(start)]) {
                    min = getLeftIdx(start);
                    swap(start, min);
                }
            } else { //左右孩子都有
                /**
                 * 先找出最大的子节点, 然后和parent比较
                 * #1 记录子节点, 需要看子节点是否仍然需要交换
                 * #2 交换值
                 */
                min = data[getLeftIdx(start)] > data[getRightIdx(start)] ? getRightIdx(start) : getLeftIdx(start);
                if (data[start] > data[min]) {
                    swap(start, min);
                }
            }
            if (min == 0) break;//满足堆条件，退出
            start = min; //不满足堆条件，还可以调整，继续循环
        }
    }

    /**
     * 由下而上调整
     *
     * @param start 开始的下标
     */
    public void siftUp(int start) {
        if (start <= 0) return;
        while (data[start] < data[getParent(start)]) {  //一直发生交换，直到满足条件
            swap(start, getParent(start));
            start = getParent(start);
            if (start <= 0) break;// root
        }
    }

    public void insert(int a) {
        /**
         * 插入的话会使数组长度加一，比较麻烦，于是我建立一个比较大的树，用一个较大的量maxSize来限定堆的最大容量，用heapSize来声明实际的容量
         */
        data[size] = a;
        siftUp(size);
        size++;
    }

    public int getLeftIdx(int i) {
        return 2 * i + 1;
    }

    public int getRightIdx(int i) {
        return 2 * i + 2;
    }

    public int getParent(int i) {
        if (i == 0) return -1;
        return (i - 1) >> 1;  //除以2
    }

    public void swap(int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + "  ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[] a = new int[]{8, 12, 2, 5, 3, 7, -1, 44, 23};
        Heap heap = new Heap(a);
        heap.display();
//        heap.build_1();
        heap.build_2();
        heap.insert(-4);
        heap.display();
    }
}
