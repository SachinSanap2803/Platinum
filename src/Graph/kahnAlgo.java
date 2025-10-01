package Graph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class kahnAlgo {

    static class TopologicalKahn {
        private int V;
        private List<List<Integer>> adj;

        TopologicalKahn(int V) {
            this.V = V;
            adj = new ArrayList<>();
            for(int i=0; i<=V; i++) {
                adj.add(new ArrayList<>());
            }
        }

        void addEdge(int u, int v) {
            adj.get(u).add(v);
        }

        void topologicalSort() {
            int[] indegree = new int[V+1];
            for(int u=1; u<=V; u++) {
                for(int v : adj.get(u)) {
                    indegree[v]++;
                }
            }

            Queue<Integer> q = new LinkedList<>();
            for(int i=1; i<=V; i++) {
                if(indegree[i] == 0) {
                    q.add(i);
                }
            }

            List<Integer> topo = new ArrayList<>();
            while (!q.isEmpty()) {
                int u = q.poll();
                topo.add(u);

                for(int v : adj.get(u)) {
                    indegree[v]--;
                    if(indegree[v] == 0) {
                        q.add(v);
                    }
                }
            }

            if(topo.size() != V) {
                System.out.println("Cycle detected in the graph");
                return;
            }

            System.out.print("Topological Sorted Data ---> ");
            for(int i : topo) {
                System.out.print(i + "  ");
            }
        }
    }

    public static void main(String[] args) {
        TopologicalKahn graph = new TopologicalKahn(7);
        graph.addEdge(1, 2);
        graph.addEdge(3, 2);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 7);

        graph.topologicalSort();
    }
}