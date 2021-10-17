package cn.spark2fire.edu.datastructure.standard.graph;

/**
 * Author: Leon@spark2fire.cn
 * QQ Group: 493306318
 * Date: 2021/10/17
 */
 public class ALVertex {
    public String data;
    public ALEdge firstEdge;

    public ALVertex() {
    }

    public ALVertex(String data) {
        this.data = data;
    }

    //not required
    public int idx;

    // not required
    public void addEdge(ALEdge edge) {
        edge.fromVerIdx = idx;
        if (firstEdge == null) {
            firstEdge = edge;
        } else {
            ALEdge lastEdge = firstEdge;
            while (lastEdge.nextEdge != null) {
                lastEdge = lastEdge.nextEdge;
            }
            lastEdge.nextEdge = edge;
        }
    }
}
