package cn.spark2fire.edu.datastructure.standard.graph;

/**
 * 思想: 从某一个顶点开始, 依次加入权值最小的顶点和边
 * 步骤:
 * #1 加入第一个顶点, 记为已访问
 * #2 在这个顶点的所有邻接边中找最小的, 记录下边的值, 同时加入这条边的端点
 * #2 在已访问的点集合中找所有邻接边最小的, 获得下一条边和点
 */
/**
 * Author: Leon@spark2fire.cn
 * QQ Group: 493306318
 * Date: 2021/10/17
 */
 public class Prim {

    private static final int INF = 99999;

    /**
     * 如果想要保存结果, 可以声明一个成员变量, 然后保存
     *
     * @param graph
     */
    public void getMST(AdjMatrixGraph graph) {
        int N = graph.vertex.length;
        int[][] edges = graph.edges;
        int[] visited = new int[N];
        int[] shortest = new int[N];

        for (int i = 0; i < N; i++) {
            shortest[i] = edges[0][i];
        }

        visited[0] = 1;

        // 先写一个for里面两个for
        for (int i = 0; i < N - 1; i++) {

            int min = INF;
            int v = 0;
            // 找最短边的点
            for (int j = 0; j < N; j++) {
                if (visited[j] == 0 && shortest[j] < min) {
                    min = shortest[j];
                    v = j;
                }
            }

            visited[v] = 1;
            System.out.println("Next Ver is : " + v);
            System.out.println("Next Edge is : " + min);
            // 更新最短边
            for (int j = 0; j < N; j++) {
                if (visited[j] == 0 && edges[v][j] < shortest[j]) {
                    shortest[j] = edges[v][j];
                }
            }
        }
    }


    public ALEdge[] getMST(AdjListsGraph graph) {
        int[] visited = new int[graph.vertices.length];
        ALEdge[] edges = new ALEdge[graph.vertices.length - 1];
        ALEdge oneEdge = null;
        int minWeight = Integer.MAX_VALUE;
        visited[0] = 1;
        for (int k = 1; k < graph.vertices.length; k++) {
            ALEdge tempEdge;
            int j = 0;
            for (int i = 0; i < graph.vertices.length; i++) {
                if (visited[i] == 1) {
                    tempEdge = graph.vertices[i].firstEdge;
                    while (tempEdge != null) {
                        if (visited[tempEdge.toVerIdx] == 0 && tempEdge.weight < minWeight) {
                            minWeight = tempEdge.weight;
                            oneEdge = tempEdge;
                            j = i;
                        }
                        tempEdge = tempEdge.nextEdge;
                    }
                }
            }
            System.out.println("< " + graph.vertices[j].data + "," + graph.vertices[oneEdge.toVerIdx].data + ">" + " : " + oneEdge.weight);
            edges[k - 1] = oneEdge;
            visited[oneEdge.toVerIdx] = 1;
            minWeight = Integer.MAX_VALUE;
        }

        return edges;
    }
}
