package cn.spark2fire.edu.datastructure.standard.graph;

/**
 * Author: Leon@spark2fire.cn
 * QQ Group: 493306318
 * Date: 2021/10/17
 */
 public class ALEdge {
    public int fromVerIdx;
    public int toVerIdx;
    public ALEdge nextEdge = null;
    public int weight;

    public ALEdge(int toVertexIdx) {
        this.toVerIdx = toVertexIdx;
    }

    public ALEdge(int toVertexIdx, int weight) {
        this.toVerIdx = toVertexIdx;
        this.weight = weight;
    }
}
