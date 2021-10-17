package cn.spark2fire.edu.datastructure.standard.graph;

/**
 * Author: Leon@spark2fire.cn
 * QQ Group: 493306318
 * Date: 2021/10/17
 */
 public class Kruskal {

    private int[] root;

    /**
     * @param graph 应该用邻接矩阵
     */
    public void getMST(AdjListsGraph graph) {
        ALEdge[] edges = graph.getEdges();
        int N = graph.vertices.length;
        ALEdge[] treeEdges = new ALEdge[N - 1];
        int length = edges.length;
        // 所有边排序一次
        edges = sortEdges(edges);
        int count = 0;
        // 把所有边从小到大走一次, N-1次就结束
        for (int i = 0; i < length; i++) {
            int fromIdx = getRoot(edges[i].fromVerIdx);
            int toIdx = getRoot(edges[i].toVerIdx);
            if (fromIdx != toIdx) {
                treeEdges[count++] = edges[i];
                root[toIdx] = fromIdx;
            }
            if (count == N - 1) {
                break;
            }
        }
    }

    // 看一条边的from和to是不是都在一个集合里面, 用并查集, 需要额外申请root数组
    private int getRoot(int idx) {
        // 死记下面这一句
        while (idx != root[idx]) {
            idx = root[idx];
        }
        return idx;
    }

    // 部分开始排序
    private ALEdge[] sortEdges(ALEdge[] edges) {
        int startIdx = 0;
        for (int i = startIdx + 1; i < edges.length; i++) {
            ALEdge temp = edges[i];
            int idx = i - 1;
            while (idx >= startIdx && temp.weight < edges[idx].weight) {
                edges[idx + 1] = edges[idx];
                idx--;
            }
            if (idx + 1 != i) {
                edges[idx + 1] = temp;
            }
        }
        return edges;
    }

}
