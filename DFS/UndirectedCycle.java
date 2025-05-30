package DFS;

public class UndirectedCycle {
    class DisjointSet {
        int[] parent;
        DisjointSet(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++)
                parent[i] = i;
        }
        
        int find(int i) {
            if (parent[i] != i)
                parent[i] = find(parent[i]);
            return parent[i];
        }
        
        void union(int x, int y) {
            parent[find(x)] = find(y);
        }
    }

    public boolean hasCycle(int[][] edges, int V) {
        DisjointSet ds = new DisjointSet(V);
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            
            if (ds.find(x) == ds.find(y))
                return true;
            ds.union(x, y);
        }
        return false;
    }

    public static void main(String[] args) {
        UndirectedCycle uc = new UndirectedCycle();
        int[][] edges = {{0,1}, {1,2}, {2,3}, {3,0}};
        System.out.println("Undirected graph contains cycle: " + 
                          uc.hasCycle(edges, 4));
    }
}