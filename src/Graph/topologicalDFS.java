package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class topologicalDFS {

    static class topological {
        private int V;
        private List<List<Integer>> adj;

        topological(int V) {
            this.V = V;
            adj = new ArrayList<>();
            for(int i=0; i<=V; i++) {
                adj.add(new ArrayList<>());
            }
        }

        void addEdge(int u, int v) {
            adj.get(u).add(v);
        }

        void DFS(int v, boolean[] visited, Stack<Integer> st) {
            visited[v] = true;
            for(int u : adj.get(v)) {
                if (!visited[u]) {
                    DFS(u, visited, st);
                }
            }
            st.push(v);
        }

        void topologicalSort() {
            boolean[] visited = new boolean[V+1];
            Stack<Integer> st = new Stack<>();

            for(int i=1; i<=V; i++) {
                if(!visited[i]) {
                    DFS(i, visited, st);
                }
            }

            System.out.print("Topological Sorted data ---> ");
            while (!st.isEmpty()) {
                System.out.print(st.pop() + "  ");
            }
        }
    }

    public static void main(String[] args) {
        topological graph = new topological(8);
        graph.addEdge(2, 1);
        graph.addEdge(2, 4);
        graph.addEdge(1, 4);
        graph.addEdge(4, 3);
        graph.addEdge(4, 5);
        graph.addEdge(6, 5);
        graph.addEdge(7, 6);
        graph.addEdge(8, 6);
        graph.addEdge(7, 4);

        graph.topologicalSort();
    }
}