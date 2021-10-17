package cn.spark2fire.edu.datastructure.standard.queue;

public interface ArrayQueue<E> {
    int getSize();

    boolean isEmpty();

    public void init(int size);

    void enQueue(Object elem);

    E deQueue();
}
