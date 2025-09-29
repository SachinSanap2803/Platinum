package Graph;

import java.util.*;

public class dijkstraAlgo {
    int V;
    List<List<Pair>> adj;

    dijkstraAlgo(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for(int i=0; i<=V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    void addEdge(int u, int v, int w) {
        adj.get(u).add(new Pair(v, w));
        adj.get(v).add(new Pair(u, w));
    }

    void shortestPath(int src) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(V, Comparator.comparingInt(o -> o.second));

        int[] dist = new int[V+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.add(new Pair(src, 0));
        dist[src] = 0;

        while(!pq.isEmpty()) {
            int u = pq.poll().first;
            for(Pair v : adj.get(u)) {
                if(dist[v.first] > dist[u] + v.second) {
                    dist[v.first] = dist[u] + v.second;
                    pq.add(new Pair(v.first, dist[v.first]));
                }
            }
        }

        for(int i=1; i<=V; i++) {
            System.out.println("From " + src + " to " + i + " : " + dist[i]);
        }
    }

    static class Pair {
        int first, second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        int V = 6;
        dijkstraAlgo g = new dijkstraAlgo(V);

        g.addEdge(1, 2, 7);
        g.addEdge(1, 3, 9);
        g.addEdge(1,6,14);
        g.addEdge(2,3,10);
        g.addEdge(2,4,15);
        g.addEdge(3,6,2);
        g.addEdge(3,4,11);
        g.addEdge(4,5,6);
        g.addEdge(5,6,9);

        g.shortestPath(1);
    }
}