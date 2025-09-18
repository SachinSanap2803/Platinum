package Graph;

import java.util.ArrayList;
import java.util.List;

public class transpose {
    static ArrayList<Integer> adj1[];
    static ArrayList<Integer> adj[];
    static int V;

    static void addEdge1(int src, int dest) {
        adj1[src].add(dest);
    }

    static void addEdge(int src, int dest) {
        adj[src].add(dest);
    }

    static List<Integer>[] transposeList() {
        adj1 = new ArrayList[V+1];
        for(int i=0; i<=V; i++) {
            adj1[i] = new ArrayList<>();
        }

        for(int i=0; i<=V; i++) {
            for(int num : adj[i]) {
                addEdge1(num, i);
            }
        }
        return adj1;
    }

    public static void main(String[] args) {
        V = 5; // example graph with 5 vertices
        adj = new ArrayList[V + 1];

        // Initialize adjacency list
        for (int i = 0; i <= V; i++) {
            adj[i] = new ArrayList<>();
        }

        // Add some edges
        addEdge(0, 1);
        addEdge(0, 4);
        addEdge(1, 2);
        addEdge(2, 3);
        addEdge(3, 0);
        addEdge(4, 1);

        // Compute transpose
        List<Integer>[] transposed = transposeList();

        // Print transpose graph
        for (int i = 0; i <= V; i++) {
            System.out.print(i + " -> ");
            for (int x : transposed[i]) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}