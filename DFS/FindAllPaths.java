package DFS;

import java.util.*;

public class FindAllPaths {
    private int vertices;
    private LinkedList<Integer>[] adj;

    FindAllPaths(int v) {
        vertices = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void findAllPaths(int src, int dest) {
        boolean[] visited = new boolean[vertices];
        List<Integer> path = new ArrayList<>();
        path.add(src);
        findAllPathsUtil(src, dest, visited, path);
    }

    void findAllPathsUtil(int src, int dest, boolean[] visited, List<Integer> path) {
        if (src == dest) {
            System.out.println(path);
            return;
        }
        visited[src] = true;
        for (int neighbor : adj[src]) {
            if (!visited[neighbor]) {
                path.add(neighbor);
                findAllPathsUtil(neighbor, dest, visited, path);
                path.remove(path.size() - 1);
            }
        }
        visited[src] = false;
    }

    public static void main(String[] args) {
        FindAllPaths g = new FindAllPaths(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        System.out.println("All paths from 0 to 4:");
        g.findAllPaths(0, 4);
        
    }
}

// All paths from 0 to 4:
// [0, 1, 3, 4]
// [0, 2, 4]