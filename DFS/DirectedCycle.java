package DFS;

import java.util.*;

public class DirectedCycle {
    private int V;
    private LinkedList<Integer>[] adj;

    DirectedCycle(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    boolean isCyclic() {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];
        
        for (int i = 0; i < V; i++)
            if (isCyclicUtil(i, visited, recStack))
                return true;
        return false;
    }

    private boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack) {
        if (recStack[i]) return true;
        if (visited[i]) return false;
        
        visited[i] = true;
        recStack[i] = true;
        
        for (Integer v : adj[i])
            if (isCyclicUtil(v, visited, recStack))
                return true;
                
        recStack[i] = false;
        return false;
    }

    public static void main(String[] args) {
        DirectedCycle g = new DirectedCycle(4);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        
        System.out.println("Graph contains cycle: " + g.isCyclic());
    }
}