package Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class primsAlgo {

    static class Pair implements Comparable<Pair> {
        int v;
        int wt;

        Pair(int v, int wt) {
            this.v = v;
            this.wt = wt;
        }

        public int compareTo(Pair that) {
            return this.wt - that.wt;
        }
    }

    static int spanningTree(int V, int E, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0; i<=V; i++) {
            adj.add(new ArrayList<Pair>());
        }

        for(int i=0; i<edges.length; i++) {
            int v1 = edges[i][0];
            int v2 = edges[i][1];
            int wt = edges[i][2];

            adj.get(v1).add(new Pair(v2, wt));
            adj.get(v2).add(new Pair(v1, wt));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        pq.add(new Pair(1, 0));
        boolean[] visited = new boolean[V+1];
        int minCost = 0;

        while(!pq.isEmpty()) {
            Pair node = pq.poll();
            int v = node.v;
            int wt = node.wt;

            if(visited[v]) {
                continue;
            }

            minCost += wt;
            visited[v] = true;
            for(Pair it : adj.get(v)) {
                if(!visited[it.v]) {
                    pq.add(new Pair(it.v, it.wt));
                }
            }
        }

        return minCost;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {1, 2, 5},
                {1, 3, 3},
                {2, 3, 4},
                {2, 4, 6},
                {2, 5, 2},
                {3, 4, 5},
                {3, 6, 6},
                {4, 5, 6},
                {4, 6, 6},
                {5, 6, 3},
                {5, 7, 4},
                {6, 7, 4}
        };

        System.out.println("Cost of Minimum Spanning Tree is : " + spanningTree(7, 12, graph));
    }
}