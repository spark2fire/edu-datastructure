package cn.spark2fire.edu.datastructure.standard.graph;

import cn.spark2fire.edu.datastructure.standard.queue.Queue;

// 邻接表
/**
 * Author: Leon@spark2fire.cn
 * QQ Group: 493306318
 * Date: 2021/10/17
 */
 public class AdjListsGraph {
    public ALVertex[] vertices;
    private int cursor;
    int[] visited;

    public AdjListsGraph(int size) {
        vertices = new ALVertex[size];
        visited = new int[size];
        cursor = 0;
    }

    public AdjListsGraph(ALVertex[] vertexes) {
        vertices = vertexes;
        visited = new int[vertexes.length];
    }

    public void addVertex(ALVertex vertex) {
        if (cursor < vertices.length) {
            vertices[cursor++] = vertex;
        } else {
            System.out.println("Full");
        }
    }

    public ALEdge[] getEdges() {
        ALEdge[] initEdges = new ALEdge[vertices.length * (vertices.length - 1)];
        int idx = 0;
        for (int i = 0; i < vertices.length; i++) {
            ALEdge edge = vertices[i].firstEdge;
            while (edge != null) {
                initEdges[idx++] = edge;
                edge = edge.nextEdge;
            }
        }

        ALEdge[] edges = new ALEdge[idx];
        for (int i = 0; i < idx; i++) {
            edges[i] = initEdges[i];
        }

        return edges;
    }

    public void DFS(int idx) {
        visited[idx] = 1;
        visit(vertices[idx]);

        ALEdge edge = vertices[idx].firstEdge;
        while (edge != null) {
            if (visited[edge.toVerIdx] == 0) {
                DFS(edge.toVerIdx);
            }
            edge = edge.nextEdge;  // 写在外面
        }
    }

    public void BFS(int idx) {
        Queue<ALVertex> queue = new Queue();
        visited[idx] = 1;
        queue.enQueue(vertices[idx]);
        visit(vertices[idx]);
        while (!queue.isEmpty()) {
            ALVertex vertex = queue.deQueue();
            ALEdge edge = vertex.firstEdge;
            while (edge != null) {
                if (visited[edge.toVerIdx] == 0) {
                    visit(vertices[edge.toVerIdx]);
                    visited[edge.toVerIdx] = 1;
                    queue.enQueue(vertices[edge.toVerIdx]);
                }
                edge = edge.nextEdge;  // 写在外面
            }
        }
    }

    private void visit(ALVertex vertex) {

    }


    public int getLoc() {
        return cursor;
    }
}