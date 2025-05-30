package DFS;
import java.util.*;

public class DFS {
    static void dfsUtil(int u, List<List<Integer>> adj, boolean[] visited) {
        visited[u] = true;
        System.out.print(u + " ");
        for (int v : adj.get(u)) {
            if (!visited[v])
                dfsUtil(v, adj, visited);
        }
    }

    static void dfs(int start, List<List<Integer>> adj, int n) {
        boolean[] visited = new boolean[n];
        dfsUtil(start, adj, visited);
    }

    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        adj.get(0).add(1); adj.get(0).add(2);
        adj.get(1).add(0); adj.get(1).add(3);
        adj.get(2).add(0); adj.get(2).add(4);
        adj.get(3).add(1);
        adj.get(4).add(2);
        dfs(0, adj, n);
    }
}






// import java.util.*;

// public class DFS {
//     static class Graph {
//         int V;
//         LinkedList<Integer>[] adj;

//         Graph(int V) {
//             this.V = V;
//             adj = new LinkedList[V];
//             for (int i = 0; i < V; i++)
//                 adj[i] = new LinkedList<>();
//         }

//         void addEdge(int v, int w) {
//             adj[v].add(w);
//         }

//         void dfsUtil(int v, boolean[] visited) {
//             visited[v] = true;
//             System.out.print(v + " ");
//             for (int n : adj[v]) {
//                 if (!visited[n])
//                     dfsUtil(n, visited);
//             }
//         }

//         void dfs(int start) {
//             boolean[] visited = new boolean[V];
//             dfsUtil(start, visited);
//         }
//     }

//     public static void main(String[] args) {
//         Graph g = new Graph(4);
//         g.addEdge(0, 1);
//         g.addEdge(0, 2);
//         g.addEdge(1, 2);
//         g.addEdge(2, 0);
//         g.addEdge(2, 3);
//         g.addEdge(3, 3);
//         System.out.print("DFS starting from vertex 2: ");
//         g.dfs(2);
//     }
// }

// // DFS starting from vertex 2: 2 0 1 3


