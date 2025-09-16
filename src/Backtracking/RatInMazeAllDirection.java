package Backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class RatInMazeAllDirection {
    public static void main(String[] args) {
        int[][] maze = {
                {1,0,0,0},
                {1,1,0,1},
                {1,1,0,0},
                {0,1,1,1},
        };
        ArrayList<String> ans = new ArrayList<>();
        int n = maze.length;
        boolean[][] isVisited = new boolean[n][n];

        if(maze[0][0] == 1) {
            isVisited[0][0] = true;
            mazePaths(maze, 0, 0, n, isVisited, ans, new StringBuilder());
        }

        Collections.sort(ans);
        System.out.println(ans);
    }

    public static void mazePaths(int[][] maze, int row, int col, int n, boolean[][] isVisited, ArrayList<String> ans, StringBuilder sb) {
        if(row == n-1 && col == n-1) {
            ans.add(sb.toString());
            return;
        }

        if(row+1 < n && maze[row+1][col] == 1 && !isVisited[row+1][col]) {
            sb.append("D");
            isVisited[row+1][col] = true;
            mazePaths(maze, row+1, col, n, isVisited, ans, sb);
            sb.deleteCharAt(sb.length()-1);
            isVisited[row+1][col] = false;
        }

        if(col-1 >= 0 && maze[row][col-1] == 1 && !isVisited[row][col-1]) {
            sb.append("L");
            isVisited[row][col-1] = true;
            mazePaths(maze, row, col-1, n, isVisited, ans, sb);
            sb.deleteCharAt(sb.length()-1);
            isVisited[row][col-1] = false;
        }

        if(col+1 < n && maze[row][col+1] == 1 && !isVisited[row][col+1]) {
            sb.append("R");
            isVisited[row][col+1] = true;
            mazePaths(maze, row, col+1, n, isVisited, ans, sb);
            sb.deleteCharAt(sb.length()-1);
            isVisited[row][col+1] = false;
        }

        if(row-1 >= 0 && maze[row-1][col] == 1 && !isVisited[row-1][col]) {
            sb.append("U");
            isVisited[row-1][col] = true;
            mazePaths(maze, row-1, col, n, isVisited, ans, sb);
            sb.deleteCharAt(sb.length()-1);
            isVisited[row-1][col] = false;
        }
    }
}