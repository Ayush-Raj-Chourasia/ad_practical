package DFS;
import java.util.*;

public class DFSWithRecursion {
    private int vertices;
    private LinkedList<Integer>[] adj;

    DFSWithRecursion(int v) {
        vertices = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int neighbor : adj[v]) {
            if (!visited[neighbor]) {
                DFSUtil(neighbor, visited);
            }
        }
    }

    void DFS(int start) {
        boolean[] visited = new boolean[vertices];
        DFSUtil(start, visited);
    }

    public static void main(String[] args) {
        DFSWithRecursion g = new DFSWithRecursion(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        System.out.println("DFS (Recursion):");
        g.DFS(0);  // Output: 0 1 3 2 4
    }
}