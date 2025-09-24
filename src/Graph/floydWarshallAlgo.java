package Graph;

public class floydWarshallAlgo {
    final static int M = (int)1e8;

    static void floydWarshall(int[][] graph, int V) {
        int i, j, k;
        for(k=1; k<=V; k++) {
            for (i=1; i<=V; i++) {
                for (j=1; j<=V; j++) {
                    if(graph[i][k] + graph[k][j] < graph[i][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }

        System.out.println("All Pair Shortest Path : ");
        for(i=1; i<=V; i++) {
            for(j=1; j<=V; j++) {
                if(graph[i][j] == M) {
                    System.out.println("M");
                } else {
                    System.out.print(graph[i][j]);
                    // System.out.println("Cost of " + i + " to " + j + " is : " + graph[i][j]);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 0, 0, 0, 0},
                {0, 0, 8, M, 0},
                {0, M, 0, 1, M},
                {0, 4, M, 0, M},
                {0, M, 2, 9, 0}
        };

        floydWarshall(graph, graph.length-1);
    }
}