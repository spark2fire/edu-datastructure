package cn.spark2fire.edu.datastructure.standard.graph.direct;

/**
 * Author: Leon@spark2fire.cn
 * QQ Group: 493306318
 * Date: 2021/10/17
 */
 public class AdjLists {
    public Vertex[] vertices;
    public int nextVertex;
    public int edgeNum;

    public AdjLists(int size) {
        vertices = new Vertex[size];
    }

    public int insertVertex(String input) {
        Vertex vertex = new Vertex(nextVertex, input);
        vertices[nextVertex++] = vertex;
        return nextVertex - 1;
    }

    public void insertEdge(Edge edge) {
        vertices[edge.from].insertEdge(edge);
        vertices[edge.to].inDegree++;
        edgeNum++;
    }
}
