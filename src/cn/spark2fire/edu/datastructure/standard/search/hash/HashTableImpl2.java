package cn.spark2fire.edu.datastructure.standard.search.hash;

import cn.spark2fire.edu.datastructure.util.DataUtil;

/**
 * Author: Leon@spark2fire.cn
 * QQ Group: 493306318
 * Date: 2021/10/17
 */
 public class HashTableImpl2 implements HashTable {

    public static int SIZE = 9999;
    public Element[] array;
    public int total;

    public HashTableImpl2() {
        array = new Element[SIZE];
    }

    // 余数法
    @Override
    public int hash(int key) {
        return key % 29;
    }

    // 闭散列方法/开址定址法 - 二次探测
    @Override
    public void put(Element element) {
        int hashcode = hash(element.key);
        if (array[hashcode] == null) {
            array[hashcode] = element;
        } else {
            int count = 1;
            while (array[hashcode + count] != null) {
                count = count + 3;
            }
            array[hashcode + count] = element;
        }
        total++;
    }

    // 二次探测会造成二次聚集
    @Override
    public Element get(int key) {
        int hashcode = hash(key);
        if (array[hashcode].key == key) {
            return array[hashcode];
        } else {
            int count = 1;
            while (array[hashcode + count] != null) {
                if (array[hashcode + count].key == key) {
                    return array[hashcode + count];
                }
                count = count + 3;
            }
            // 没找到
            return null;
        }
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTableImpl2();
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
