package Graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class detectCycle {
    static List<Integer>[] adj;
    static int V;

    // Add edge (undirected)
    static void addEdge(int src, int dest) {
        adj[src].add(dest);
        adj[dest].add(src);
    }

    // DFS helper
    static boolean isCyclic(int v, boolean[] visited, int parent) {
        visited[v] = true;

        Iterator<Integer> it = adj[v].iterator();
        while (it.hasNext()) {
            int i = it.next();

            if (!visited[i]) {
                if (isCyclic(i, visited, v)) {
                    return true;
                }
            }
            // If visited and not parent, cycle found
            else if (i != parent) {
                return true;
            }
        }
        return false;
    }

    // Main cycle detection function
    static boolean detectCycle() {
        boolean[] visited = new boolean[V];

        for (int u = 0; u < V; u++) {
            if (!visited[u]) {
                if (isCyclic(u, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        V = 5;
        adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }

        // Create a graph
        addEdge(0, 1);
        addEdge(1, 2);
        addEdge(2, 3);
        addEdge(3, 4);
        addEdge(4, 1);

        if (detectCycle()) {
            System.out.println("Graph contains cycle");
        } else {
            System.out.println("Graph does not contain cycle");
        }
    }
}