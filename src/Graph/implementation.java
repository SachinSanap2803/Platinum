package Graph;

import java.util.Scanner;

public class implementation {

    static void addEdges(int src, int dest, int[][] graph) {
        graph[src][dest] = 1;
        graph[dest][src] = 1;       // for undirected graph
    }

    static void printGraph(int[][] graph) {
        for(int i=1; i<graph.length; i++) {
            for(int j=1; j<graph.length; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter no.of vertices : ");
        int V = sc.nextInt();
        System.out.print("Enter no. of edges : ");
        int E = sc.nextInt();

        int[][] graph = new int[V+1][V+1];

        for(int i=0; i<E; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            addEdges(a, b, graph);
        }

        printGraph(graph);
    }
}