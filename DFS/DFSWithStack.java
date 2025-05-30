package DFS;
import java.util.*;

public class DFSWithStack {
    private int vertices;
    private LinkedList<Integer>[] adj;

    DFSWithStack(int v) {
        vertices = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList<>();
    }
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void DFS(int start) {
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (!visited[current]) {
                System.out.print(current + " ");
                visited[current] = true;
            }
            for (int neighbor : adj[current]) {
                if (!visited[neighbor]) {
                    stack.push(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        DFSWithStack g = new DFSWithStack(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        System.out.println("DFS (Stack):");
        g.DFS(0);
    }
}