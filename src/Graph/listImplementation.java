package Graph;

import java.util.ArrayList;
import java.util.Scanner;

public class listImplementation {
    static ArrayList<Integer> adj[];

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter no. of vertices : ");
        int V = sc.nextInt();

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
    }
}