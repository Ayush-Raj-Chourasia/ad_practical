package DFS;

import java.util.*;

public class AllPaths {
    private int V;
    private LinkedList<Integer>[] adj;

    AllPaths(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void printAllPaths(int s, int d) {
        boolean[] visited = new boolean[V];
        ArrayList<Integer> path = new ArrayList<>();
        path.add(s);
        printAllPathsUtil(s, d, visited, path);
    }

    private void printAllPathsUtil(Integer u, Integer d, boolean[] visited, List<Integer> path) {
        if (u.equals(d)) {
            System.out.println(path);
            return;
        }
        visited[u] = true;
        for (Integer i : adj[u]) {
            if (!visited[i]) {
                path.add(i);
                printAllPathsUtil(i, d, visited, path);
                path.remove(i);
            }
        }
        visited[u] = false;
    }

    public static void main(String[] args) {
        AllPaths g = new AllPaths(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(2, 0);
        g.addEdge(2, 1);
        g.addEdge(1, 3);
        
        System.out.println("All paths from 2 to 3:");
        g.printAllPaths(2, 3);
    }
}