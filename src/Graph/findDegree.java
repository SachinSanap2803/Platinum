package Graph;

public class findDegree {

    static int inDegree(int n, int[][] graph) {
        int count = 0;
        for(int i=0; i<graph.length; i++) {
            if(graph[i][n] == 1) {
                count++;
            }
        }
        return count;
    }

    static int outDegree(int n, int[][] graph) {
        int count = 0;
        for(int i=0; i<graph.length; i++) {
            if(graph[n][i] == 1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}