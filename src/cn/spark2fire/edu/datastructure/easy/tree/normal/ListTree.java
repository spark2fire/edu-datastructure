package cn.spark2fire.edu.datastructure.easy.tree.normal;

public class ListTree {
    ListTreeNode[] array;
    private int currentIdx;
    private int length = 20;

    public ListTree() {
        this.init();
    }

    public ListTree(int size) {
        this.length = size;
        this.init();
    }

    private void init() {
        array = new ListTreeNode[length];
        currentIdx = -1;
    }

    public void add(ListTreeNode node) {
        if (currentIdx < length - 1) {
            array[++currentIdx] = node;
        }
    }

    
}