package Dijkstra;
import java.util.*;

public class Dijkstra {
    static class Node implements Comparable<Node> {
        int vertex, weight;
        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static void dijkstra(List<List<Node>> adj, int src, int n) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(src, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int u = curr.vertex;
            if (curr.weight > dist[u]) continue;

            for (Node node : adj.get(u)) {
                int v = node.vertex;
                int w = node.weight;
                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }

        System.out.println("Shortest distances from source:");
        for (int i = 0; i < n; i++)
            System.out.println(i + ": " + dist[i]);
    }

    public static void main(String[] args) {
        int n = 6;
        List<List<Node>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        adj.get(0).add(new Node(1, 10));
        adj.get(0).add(new Node(5, 8));
        adj.get(1).add(new Node(3, 2));
        adj.get(2).add(new Node(1, 1));
        adj.get(3).add(new Node(2, -2));
        adj.get(4).add(new Node(1, -4));
        adj.get(4).add(new Node(3, -1));
        adj.get(5).add(new Node(4, 1));
        dijkstra(adj, 0, n);
    }
}