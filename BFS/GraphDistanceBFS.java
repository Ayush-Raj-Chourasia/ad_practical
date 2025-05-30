package BFS;

import java.util.*;

public class GraphDistanceBFS {
    private static final int V = 5;

 
    static int[][] adjMatrix = new int[V][V];

  
    static void addEdge(int u, int v) {
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1;
    }

    // Print adjacency matrix
    static void printAdjMatrix() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // BFS to find shortest distance
    static int bfsDistance(int src, int dest) {
        boolean[] visited = new boolean[V];
        int[] distance = new int[V];

        Queue<Integer> queue = new LinkedList<>();
        visited[src] = true;
        queue.add(src);
        distance[src] = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v = 0; v < V; v++) {
                if (adjMatrix[u][v] == 1 && !visited[v]) {
                    visited[v] = true;
                    distance[v] = distance[u] + 1;
                    queue.add(v);
                }
            }
        }

        return distance[dest];
    }

    public static void main(String[] args) {
        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(2, 3);
        addEdge(1, 3);
        addEdge(3, 4);
        addEdge(1, 4);

        printAdjMatrix();

        int source = 0, destination = 4;
        int dist = bfsDistance(source, destination);

        System.out.println("\nShortest Distance from " + source + " to " + destination + " = " + dist);
    }
}
