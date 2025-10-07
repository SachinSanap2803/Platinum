package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class IsGraphBipartite {

    public static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];

        for(int i=0; i<n; i++) {
            if(colors[i] != 0) continue;

            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            colors[i] = 1;

            while (!q.isEmpty()) {
                int node = q.poll();
                for(int neighbour : graph[node]) {
                    if(colors[neighbour] == 0) {
                        colors[neighbour] = -colors[node];
                        q.offer(neighbour);
                    } else if(colors[neighbour] == colors[node]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = {{1,3},{0,2},{1,3},{0,2}};
        System.out.println(isBipartite(graph));
    }
}