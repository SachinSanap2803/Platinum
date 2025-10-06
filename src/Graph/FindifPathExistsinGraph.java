package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindifPathExistsinGraph {

    public static boolean validPath(int n, int[][] edges, int source, int dest) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        visited[source] = true;

        while(!q.isEmpty()) {
            int node = q.poll();
            if(node == dest) {
                return true;
            }

            for(int x : adj.get(node)) {
                if(!visited[x]) {
                    q.add(x);
                    visited[x] = true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0,1},{0,2},{3,5},{5,4},{4,3}};
        int source = 0;
        int dest = 5;

        boolean ans = validPath(n, edges, source, dest);
        System.out.println(ans);
    }
}