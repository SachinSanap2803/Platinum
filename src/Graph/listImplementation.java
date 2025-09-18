package Graph;

import java.util.*;

public class listImplementation {
    static ArrayList<Integer> adj[];
    static int V;

    listImplementation(int V) {
        adj = new ArrayList[V+1];
        for(int i=0; i<=V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    static void addEdge(int src, int dest) {
        adj[src].add(dest);
        adj[dest].add(src);
    }

    static void printGraph(int V) {
        for(int i=1; i<=V; i++) {
            System.out.print(i + " ->");
            for(int node : adj[i]) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }

    static void BFS(int n) {
        boolean[] visited = new boolean[V+1];
        Queue<Integer> q = new LinkedList<>();
        visited[n] = true;
        q.add(n);

        while(!q.isEmpty()) {
            n = q.poll();
            System.out.print(n + " ");

            Iterator<Integer> i = adj[n].listIterator();
            while (i.hasNext()) {
                int x = i.next();
                if(!visited[x]) {
                    visited[x] = true;
                    q.add(x);
                }
            }
        }

//        while (!q.isEmpty()) {
//            n = q.poll();
//            System.out.print(n + " ");
//
//            for (int x : adj[n]) {
//                if (!visited[x]) {
//                    visited[x] = true;
//                    q.add(x);
//                }
//            }
//        }
    }

    static void DFS(int n, boolean[] visited) {
        visited[n] = true;
        System.out.print(n + " ");

        Iterator<Integer> i = adj[n].listIterator();
        while (i.hasNext()) {
            int x = i.next();
            if(!visited[x]) {
                DFS(x, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter no. of vertices : ");
        V = sc.nextInt();

        System.out.print("Enter no. of Edges : ");
        int E = sc.nextInt();

        listImplementation g = new listImplementation(V);

        for(int i=0; i<E; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            addEdge(a, b);
        }

        System.out.println("Adjacency List : ");
        printGraph(V);

        System.out.print("BFS : ");
        BFS(V);
        System.out.println();

        System.out.print("DFS : ");
        boolean[] visited = new boolean[V+1];
        DFS(V, visited);
    }
}