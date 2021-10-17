package cn.spark2fire.edu.datastructure.standard.graph;

/**
 * Author: Leon@spark2fire.cn
 * QQ Group: 493306318
 * Date: 2021/10/17
 */
 public class AdjMatrixGraph {
    private static final int INF = 99999;
    // 全部写成public，这样可以直接访问
    public String[] vertex;
    public int[][] edges;

    public AdjMatrixGraph(int size) {
        vertex = new String[size];
        edges = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                edges[i][j] = INF;
            }
        }
    }

    public AdjMatrixGraph(String[] vertexes) {
        vertex = vertexes;
        int size = vertexes.length;
        edges = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    edges[i][j] = 0;
                } else {
                    edges[i][j] = INF;
                }
            }
        }
    }

    public void printGraph() {
        int size = vertex.length;
        for (int i = 0; i < size; i++) {
            System.out.printf("%7s", vertex[i]);
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (edges[i][j] == INF) {
                    System.out.printf("%7s", "-");
                } else {
                    System.out.printf("%7d", edges[i][j]);
                }
            }
            System.out.println();
        }
    }
}
