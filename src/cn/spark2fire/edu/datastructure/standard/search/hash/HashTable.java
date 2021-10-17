package cn.spark2fire.edu.datastructure.standard.search.hash;

public interface HashTable {
    int hash(int key);

    void put(Element element);

    Element get(int key);
}
