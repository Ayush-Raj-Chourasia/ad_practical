package MST;
import java.util.*;

public class Prims {
    static class Edge implements Comparable<Edge> {
        int node, weight;
        public Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static void prim(List<List<Edge>> adj, int n) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] mstSet = new boolean[n];
        int[] key = new int[n];
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;
        pq.add(new Edge(0, 0));

        while (!pq.isEmpty()) {
            int u = pq.poll().node;
            if (mstSet[u]) continue;
            mstSet[u] = true;

            for (Edge e : adj.get(u)) {
                int v = e.node;
                int w = e.weight;
                if (!mstSet[v] && w < key[v]) {
                    key[v] = w;
                    pq.add(new Edge(v, w));
                }
            }
        }

        System.out.println("Minimum Spanning Tree Weight: " + Arrays.stream(key).sum());
    }

    public static void main(String[] args) {
        int n = 5;
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        adj.get(0).add(new Edge(1, 2)); adj.get(0).add(new Edge(3, 6));
        adj.get(1).add(new Edge(0, 2)); adj.get(1).add(new Edge(2, 3));
        adj.get(1).add(new Edge(3, 8)); adj.get(1).add(new Edge(4, 5));
        adj.get(2).add(new Edge(1, 3)); adj.get(2).add(new Edge(4, 7));
        adj.get(3).add(new Edge(0, 6)); adj.get(3).add(new Edge(1, 8));
        adj.get(4).add(new Edge(1, 5)); adj.get(4).add(new Edge(2, 7));
        prim(adj, n);
    }
}