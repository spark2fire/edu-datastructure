package cn.spark2fire.edu.datastructure.standard.search.hash;

import cn.spark2fire.edu.datastructure.util.DataUtil;

/**
 * 直接定址法
 */
/**
 * Author: Leon@spark2fire.cn
 * QQ Group: 493306318
 * Date: 2021/10/17
 */
 public class HashTableImpl1 implements HashTable {

    public static int SIZE = 9999;

    private Element[] array;
    // 有效数据个数
    public int count;

    // 直接定址法
    @Override
    public int hash(int key) {
        return key * 3 + 7;
    }

    public HashTableImpl1() {
        array = new Element[SIZE];
    }

    // 开散列方法/拉链法
    @Override
    public void put(Element element) {
        int hashcode = hash(element.key);
        if (array[hashcode] == null) {
            array[hashcode] = element;
        } else {
            addElement(element, array[hashcode]);
        }
        count++;
    }

    private void addElement(Element newElem, Element firstElem) {
        Element temp = firstElem;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newElem;
    }

    // 取决于put的方法
    @Override
    public Element get(int key) {
        int hashcode = hash(key);
        if (array[hashcode].key == key) {
            return array[hashcode];
        } else {
            Element temp = array[hashcode];
            while (temp != null) {
                if (temp.key == key) {
                    return temp;
                }
                temp = temp.next;
            }
            // 没找到
            return null;
        }
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTableImpl1();
        Element insert;
        Integer[] keys = DataUtil.genUniqueArray(200, 1000);
        Integer mark1 = null;
        Integer mark2 = null;
        for (Integer key : keys) {
            insert = new Element(key, DataUtil.getRandomString(10));
            if (mark1 == null && key % 13 == 0) {
                mark1 = key;
                System.out.println(key + " - " + insert.data);
            }
            if (mark2 == null && key % 17 == 0) {
                mark2 = key;
                System.out.println(key + " - " + insert.data);
            }
            hashTable.put(insert);
        }
        System.out.println(hashTable.get(mark1));
        System.out.println(hashTable.get(mark2));
    }
}
