package MST;


import java.util.*;

public class Kruskals {
    static class UnionFind {
        int[] parent, rank;
        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int x, int y) {
            int xr = find(x), yr = find(y);
            if (xr == yr) return;
            if (rank[xr] < rank[yr])
                parent[xr] = yr;
            else {
                parent[yr] = xr;
                if (rank[xr] == rank[yr]) rank[xr]++;
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int u, v, w;
        public Edge(int u, int v, int w) {
            this.u = u; this.v = v; this.w = w;
        }
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
    }

    static void kruskal(List<Edge> edges, int n) {
        Collections.sort(edges);
        UnionFind uf = new UnionFind(n);
        int totalWeight = 0;

        for (Edge e : edges) {
            if (uf.find(e.u) != uf.find(e.v)) {
                uf.union(e.u, e.v);
                totalWeight += e.w;
            }
        }

        System.out.println("Total MST Weight: " + totalWeight);
    }

    public static void main(String[] args) {
        int n = 4;
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));
        kruskal(edges, n);
    }
}


















// import java.util.*;

// public class KruskalMST {
//     static class Edge implements Comparable<Edge> {
//         int src, dest, weight;
//         public int compareTo(Edge compare) {
//             return this.weight - compare.weight;
//         }
//     }

//     static class Subset {
//         int parent, rank;
//     }

//     int V, E;
//     Edge[] edges;

//     KruskalMST(int v, int e) {
//         V = v; E = e;
//         edges = new Edge[E];
//         for (int i = 0; i < E; i++)
//             edges[i] = new Edge();
//     }

//     int find(Subset[] subsets, int i) {
//         if (subsets[i].parent != i)
//             subsets[i].parent = find(subsets, subsets[i].parent);
//         return subsets[i].parent;
//     }

//     void union(Subset[] subsets, int x, int y) {
//         int xroot = find(subsets, x);
//         int yroot = find(subsets, y);

//         if (subsets[xroot].rank < subsets[yroot].rank)
//             subsets[xroot].parent = yroot;
//         else if (subsets[xroot].rank > subsets[yroot].rank)
//             subsets[yroot].parent = xroot;
//         else {
//             subsets[yroot].parent = xroot;
//             subsets[xroot].rank++;
//         }
//     }

//     void kruskalMST() {
//         Arrays.sort(edges);
//         Edge[] result = new Edge[V - 1];
//         int e = 0, i = 0;
//         Subset[] subsets = new Subset[V];
//         for (int v = 0; v < V; v++) {
//             subsets[v] = new Subset();
//             subsets[v].parent = v;
//             subsets[v].rank = 0;
//         }

//         while (e < V - 1) {
//             Edge next = edges[i++];
//             int x = find(subsets, next.src);
//             int y = find(subsets, next.dest);
//             if (x != y) {
//                 result[e++] = next;
//                 union(subsets, x, y);
//             }
//         }

//         for (i = 0; i < e; i++)
//             System.out.println(result[i].src + " - " + result[i].dest + " : " + result[i].weight);
//     }

//     public static void main(String[] args) {
//         int V = 4, E = 5;
//         KruskalMST g = new KruskalMST(V, E);

//         g.edges[0].src = 0; g.edges[0].dest = 1; g.edges[0].weight = 10;
//         g.edges[1].src = 0; g.edges[1].dest = 2; g.edges[1].weight = 6;
//         g.edges[2].src = 0; g.edges[2].dest = 3; g.edges[2].weight = 5;
//         g.edges[3].src = 1; g.edges[3].dest = 3; g.edges[3].weight = 15;
//         g.edges[4].src = 2; g.edges[4].dest = 3; g.edges[4].weight = 4;

//         g.kruskalMST();
//     }
// }
