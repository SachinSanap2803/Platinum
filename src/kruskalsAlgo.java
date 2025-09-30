import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class kruskalsAlgo {

    static class Edge {
        int src, dest, weight;
        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    static class SubSet {
        int parent, rank;
        public SubSet(int parent, int rank) {
            this.parent = parent;
            this.rank = rank;
        }
    }

    private static int findRoot(SubSet[] subsets, int i) {
        if(subsets[i].parent == i) {
            return subsets[i].parent;
        }
        subsets[i].parent = findRoot(subsets, subsets[i].parent);
        return subsets[i].parent;
    }

    private static void union(SubSet[] subSets, int x, int y) {
        int rootX = findRoot(subSets, x);
        int rootY = findRoot(subSets, y);

        if(subSets[rootY].rank < subSets[rootX].rank) {
            subSets[rootY].parent = rootX;
        } else if(subSets[rootX].rank < subSets[rootY].rank) {
            subSets[rootX].parent = rootY;
        } else {
            subSets[rootY].parent = rootX;
            subSets[rootX].rank++;
        }
    }

    public static void kruskals(int V, List<Edge> edges) {
        int j = 0;
        int noOfEdges = 0;

        SubSet[] subsets = new SubSet[V];
        Edge[] res = new Edge[V-1];

        // Create V subsets with single element
        for(int i=0; i<V; i++) {
            subsets[i] = new SubSet(i, 0);
        }

        while(noOfEdges < V-1 && j < edges.size()) {
            Edge nextEdge = edges.get(j);
            int x = findRoot(subsets, nextEdge.src);
            int y = findRoot(subsets, nextEdge.dest);

            if(x != y) {
                res[noOfEdges] = nextEdge;
                union(subsets, x, y);
                noOfEdges++;
            }
            j++;
        }

        if (noOfEdges != V - 1) {
            System.out.println("The graph is disconnected; MST cannot be formed.");
            return;
        }

        System.out.println("Minimum Spanning Tree : ");
        int minCost = 0;
        for(int i=0; i<noOfEdges; i++) {
            System.out.println(res[i].src + " -- " + res[i].dest + " : " + res[i].weight);
            minCost += res[i].weight;
        }
        System.out.println("MST : " + minCost);
    }

    public static void main(String[] args) {
        int V = 4;
        List<Edge> graphEdges = new ArrayList<Edge>(List.of(new Edge(0, 1, 10),
                new Edge(0, 2, 6),
                new Edge(1, 3, 15),
                new Edge(2, 3, 4)));

        graphEdges.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });

        kruskals(V, graphEdges);
    }
}