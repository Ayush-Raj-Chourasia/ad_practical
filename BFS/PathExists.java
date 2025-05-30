package BFS;

import java.util.*;

public class PathExists {
    private int vertices;
    private LinkedList<Integer>[] adj;

    PathExists(int v) {
        vertices = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    boolean hasPathDFS(int src, int dest) {
        boolean[] visited = new boolean[vertices];
        return hasPathDFSUtil(src, dest, visited);
    }

    boolean hasPathDFSUtil(int src, int dest, boolean[] visited) {
        if (src == dest) return true;
        visited[src] = true;
        for (int neighbor : adj[src]) {
            if (!visited[neighbor] && hasPathDFSUtil(neighbor, dest, visited)) {
                return true;
            }
        }
        return false;
    }

    boolean hasPathBFS(int src, int dest) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        visited[src] = true;
        queue.add(src);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == dest) return true;
            for (int neighbor : adj[current]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PathExists g = new PathExists(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        System.out.println("Path exists (DFS): " + g.hasPathDFS(0, 4));  // true
        System.out.println("Path exists (BFS): " + g.hasPathBFS(0, 3));  // true
    }
}