package cn.spark2fire.edu.datastructure.standard.graph;

/**
 * 动态规划
 * Floyd会计算出各个顶点之间的最短路径, 而Dijkstra只计算制定出发顶点
 */
/**
 * Author: Leon@spark2fire.cn
 * QQ Group: 493306318
 * Date: 2021/10/17
 */
 public class Floyd {
    private static final int INF = Integer.MAX_VALUE;
    //对于二维数组, 记录的是第i个节点到各个节点的距离


    public int[][] calPath(AdjMatrixGraph graph) {
        int N = graph.vertex.length;
        int[][] matrix = new int[N][N];
        int[][] prevNode = new int[N][N];
        copy(matrix, graph.edges, N);
        // k是中间节点
        for (int k = 0; k < N; k++) {
            // i是起点
            for (int i = 0; i < N; i++) {
                // j是终点
                for (int j = 0; j < N; j++) {
                    if (i != j && matrix[i][k] != INF && matrix[k][j] != INF && (matrix[i][j] > matrix[i][k] + matrix[k][j])) {
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                        prevNode[i][j] = k;
                    }
                }
            }
        }
        return matrix;
    }

    private void copy(int[][] target, int[][] source, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                target[i][j] = source[i][j];
            }
        }
    }

}
