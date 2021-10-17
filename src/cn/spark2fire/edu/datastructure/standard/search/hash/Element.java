package cn.spark2fire.edu.datastructure.standard.search.hash;

/**
 * Author: Leon@spark2fire.cn
 * QQ Group: 493306318
 * Date: 2021/10/17
 */
 public class Element {
    public int key;
    public String data;
    public Element next;

    public Element(int key, String data) {
        this.key = key;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Key: " + key + ", Value: " + data;
    }
}
