package cn.spark2fire.edu.datastructure.standard.graph;

/**
 * refer to: https://www.cnblogs.com/skywang12345/p/3711516.html
 * 通过Dijkstra计算图G中的最短路径时，需要指定起点s(即从顶点s开始计算)。
 * 此外，引进两个集合S和U。S的作用是记录已求出最短路径的顶点(以及相应的最短路径长度)，而U则是记录还未求出最短路径的顶点(以及该顶点到起点s的距离)。
 * <p>
 * 1 初始时，S只包含起点s；U包含除s外的其他顶点，且U中顶点的距离为"起点s到该顶点的距离"[例如，U中顶点v的距离为(s,v)的长度，然后s和v不相邻，则v的距离为∞]。
 * <p>
 * 2 从U中选出"距离最短的顶点k"，并将顶点k加入到S中；同时，从U中移除顶点k。
 * <p>
 * 3 更新U中各个顶点到起点s的距离。之所以更新U中顶点的距离，是由于上一步中确定了k是求出最短路径的顶点，从而可以利用k来更新其它顶点的距离；例如，(s,v)的距离可能大于(s,k)+(k,v)的距离。
 * <p>
 * 4 重复步骤2和3，直到遍历完所有顶点。
 * <p>
 * <p>
 * 其中, 第2步非常有意义, 每次算出来的最短节点一定是下一个计算节点
 * <p>
 * 更适合用邻接矩阵
 */
/**
 * Author: Leon@spark2fire.cn
 * QQ Group: 493306318
 * Date: 2021/10/17
 */
 public class Dijkstra {

    private static final int INF = 99999;

    public int[] preNode;

    /**
     * @param graph 最好是邻接矩阵
     * @param start
     * @return
     */
    public int[] calPath(AdjMatrixGraph graph, int start) {
        // 顶点个数
        int size = graph.vertex.length;
        // 辅助数组, 记录顶点是否已经访问, 1表示已经访问过, 这个用来做加入U和踢出S
        int[] visited = new int[size];
        // 辅助数组, 记录各顶点和出发点的距离, 逐渐更新为最短距离
        int[] distance = new int[size];
        // 辅助数组, 记录前驱节点, -1表示没有前驱节点
        preNode = new int[size];

        for (int i = 0; i < size; i++) {
            distance[i] = INF;
            distance[i] = INF;
            preNode[i] = -1;
        }

        visited[start] = 1;
        // 先更新start直接连接点
        for (int i = 0; i < size; i++) {
            distance[i] = graph.edges[start][i];
        }

        // n-1次
        for (int i = 0; i < size - 1; i++) {

            int min = INF;
            int idx = -1;
            //找点
            for (int j = 0; j < size; j++) {
                if (visited[j] == 0 && distance[j] < min) {
                    idx = j;
                    min = distance[j];
                }
            }

            //设置点已访问
            visited[idx] = 1;

            //更新边
            for (int k = 0; k < size; k++) {
                if (visited[k] == 0 && distance[k] > graph.edges[k][idx] + distance[idx]) {
                    distance[k] = distance[idx] + graph.edges[idx][k];
                    preNode[k] = idx;
                }
            }

        }
        return distance;
    }
}
