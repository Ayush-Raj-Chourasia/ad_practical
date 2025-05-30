package BFS;
import java.util.*;

public class BFS {
    static void bfs(int start, List<List<Integer>> adj, int n) {
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int u = q.poll();
            System.out.print(u + " ");
            for (int v : adj.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    q.add(v);
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        // Add edges
        adj.get(0).add(1); adj.get(0).add(2);
        adj.get(1).add(0); adj.get(1).add(3);
        adj.get(2).add(0); adj.get(2).add(4);
        adj.get(3).add(1);
        adj.get(4).add(2);
        bfs(0, adj, n);
    }
}







// import java.util.*;

// public class BFS {
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

//         void bfs(int start) {
//             boolean[] visited = new boolean[V];
//             Queue<Integer> queue = new LinkedList<>();
//             visited[start] = true;
//             queue.add(start);

//             while (!queue.isEmpty()) {
//                 int node = queue.poll();
//                 System.out.print(node + " ");

//                 for (int n : adj[node]) {
//                     if (!visited[n]) {
//                         visited[n] = true;
//                         queue.add(n);
//                     }
//                 }
//             }
//         }
//     }

//     public static void main(String[] args) {
//         Graph g = new Graph(4);
//         g.addEdge(0, 1); g.addEdge(0, 2); g.addEdge(1, 2); g.addEdge(2, 0); g.addEdge(2, 3); g.addEdge(3, 3);

//         System.out.print("BFS starting from vertex 2: ");
//         g.bfs(2);
//     }
// }
