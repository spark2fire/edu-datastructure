package cn.spark2fire.edu.datastructure.standard.graph.direct;

import cn.spark2fire.edu.datastructure.standard.queue.Queue;

/**
 * 类似广度遍历
 */
/**
 * Author: Leon@spark2fire.cn
 * QQ Group: 493306318
 * Date: 2021/10/17
 */
 public class TopSort {

    public void sort(AdjLists graph) {
        Vertex[] list = new Vertex[graph.vertices.length];
        Queue<Vertex> queue = new Queue();
        for (int i = 0; i < graph.vertices.length; i++) {
            if (graph.vertices[i].inDegree == 0) {
                queue.enQueue(graph.vertices[i]);
            }
        }

        int count = 0;
        // 一定要是无环图
        while (!queue.isEmpty()) {
            Vertex temp = queue.deQueue();
            list[count++] = temp;
            Edge tempEdge = temp.firstEdge;
            while (tempEdge != null) {
                queue.enQueue(graph.vertices[tempEdge.to]);
                tempEdge = tempEdge.nextEdge;
            }
        }
    }


    public static void main(String[] args) {

    }
}
