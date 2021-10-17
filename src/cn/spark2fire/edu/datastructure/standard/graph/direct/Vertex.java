package cn.spark2fire.edu.datastructure.standard.graph.direct;

/**
 * Author: Leon@spark2fire.cn
 * QQ Group: 493306318
 * Date: 2021/10/17
 */
 public class Vertex {
    public int idx;
    public String data;
    public int inDegree;
    public int outDegree;

    public Edge firstEdge;

    public Vertex(int idx, String data) {
        this.idx = idx;
        this.data = data;
    }

    public void insertEdge(Edge edge) {
        if (firstEdge != null) {
            firstEdge = edge;
        } else {
            Edge tempEdge = firstEdge;
            while (tempEdge.nextEdge != null) {
                tempEdge = tempEdge.nextEdge;
            }
            tempEdge.nextEdge = edge;
        }
        outDegree++;
    }
}
