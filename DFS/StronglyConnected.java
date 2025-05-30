package DFS;

import java.util.*;

public class StronglyConnected {
    private int V;
    private LinkedList<Integer>[] adj;

    StronglyConnected(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    boolean isStronglyConnected() {
        boolean[] visited = new boolean[V];
        DFSUtil(0, visited);
        for (boolean b : visited) if (!b) return false;
        
        StronglyConnected reversed = getTranspose();
        Arrays.fill(visited, false);
        reversed.DFSUtil(0, visited);
        for (boolean b : visited) if (!b) return false;
        
        return true;
    }

    private void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        for (int n : adj[v])
            if (!visited[n]) DFSUtil(n, visited);
    }

    private StronglyConnected getTranspose() {
        StronglyConnected g = new StronglyConnected(V);
        for (int v = 0; v < V; v++)
            for (int n : adj[v])
                g.addEdge(n, v);
        return g;
    }

    public static void main(String[] args) {
        StronglyConnected g1 = new StronglyConnected(5);
        g1.addEdge(0, 1);
        g1.addEdge(1, 2);
        g1.addEdge(2, 3);
        g1.addEdge(3, 0);
        g1.addEdge(2, 4);
        g1.addEdge(4, 2);
        System.out.println("Graph is strongly connected: " + g1.isStronglyConnected());
    }
}
