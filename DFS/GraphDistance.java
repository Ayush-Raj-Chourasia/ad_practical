package DFS;

import java.util.*;

public class GraphDistance {
    private int V;
    private LinkedList<Integer>[] adj;

    GraphDistance(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    int findDistance(int s, int d) {
        int[] dist = new int[V];
        Arrays.fill(dist, -1);
        Queue<Integer> queue = new LinkedList<>();
        dist[s] = 0;
        queue.add(s);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : adj[u]) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    queue.add(v);
                    if (v == d) return dist[v];
                }
            }
        }
        return -1; // No path exists
    }

    public static void main(String[] args) {
        GraphDistance g = new GraphDistance(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        
        System.out.println("Distance from 1 to 3: " + g.findDistance(1, 3));
    }
}