package Backtracking;

// 1] Return true or false

//public class RatInMaze {
//    static boolean flag;
//
//    public static void main(String[] args) {
//        int[][] arr = {
//                {1,1,1,0,1,0},
//                {1,0,1,0,0,1},
//                {1,0,1,1,1,0},
//                {0,1,1,1,0,1},
//                {1,1,0,1,1,1}
//        };
//        maze(arr, 0, 0, arr.length, arr[0].length);
//        System.out.println(flag);
//    }
//
//    public static void maze(int[][] arr, int row, int col, int n, int m) {
//        if(row == n-1 && col == m-1) {
//            flag = true;
//        }
//        if(row+1 != n && arr[row+1][col] == 1) {
//            maze(arr, row+1, col, n, m);
//        }
//        if(col+1 != m && arr[row][col+1] == 1) {
//            maze(arr, row, col+1, n, m);
//        }
//        return;
//    }
//}





// 2] return no. of steps

//public class RatInMaze {
//    static int finalCount;
//
//    public static void main(String[] args) {
//        int[][] arr = {
//                {1,1,1,0,1,0},
//                {1,0,1,0,0,1},
//                {1,0,1,1,1,0},
//                {0,1,1,1,0,1},
//                {1,1,0,1,1,1}
//        };
//        int count = 0;
//        maze(arr, 0, 0, arr.length, arr[0].length, count);
//        System.out.println(finalCount);
//    }
//
//    public static void maze(int[][] arr, int row, int col, int n, int m, int count) {
//        if(row == n-1 && col == m-1) {
//            finalCount = count;
//        }
//        if(row+1 != n && arr[row+1][col] == 1) {
//            maze(arr, row+1, col, n, m, count+1);
//        }
//        if(col+1 != m && arr[row][col+1] == 1) {
//            maze(arr, row, col+1, n, m, count+1);
//        }
//    }
//}




// 3] No. of ways

//public class RatInMaze {
//    static int totalWays;
//
//    public static void main(String[] args) {
//        int[][] arr = {
//                {1,1,1,0,1,0},
//                {1,0,1,0,0,1},
//                {1,0,1,1,1,0},
//                {0,1,1,1,0,1},
//                {1,1,0,1,1,1}
//        };
//        maze(arr, 0, 0, arr.length, arr[0].length);
//        System.out.println(totalWays);
//    }
//
//    public static void maze(int[][] arr, int row, int col, int n, int m) {
//        if(row == n-1 && col == m-1) {
//            totalWays++;
//        }
//        if(row+1 != n && arr[row+1][col] == 1) {
//            maze(arr, row+1, col, n, m);
//        }
//        if(col+1 != m && arr[row][col+1] == 1) {
//            maze(arr, row, col+1, n, m);
//        }
//    }
//}




// 4] Return path as a string

import java.util.ArrayList;

public class RatInMaze {
    public static void main(String[] args) {
        int[][] arr = {
                {1,1,1,0,1,0},
                {1,0,1,0,0,1},
                {1,0,1,1,1,0},
                {0,1,1,1,0,1},
                {1,1,0,1,1,1}
        };
        ArrayList<String> ans = new ArrayList<>();
        maze(arr, 0, 0, arr.length, arr[0].length, new StringBuilder(), ans);
        for(String s : ans) {
            System.out.println(s);
        }
    }

    public static void maze(int[][] arr, int row, int col, int n, int m, StringBuilder sb, ArrayList<String> ans) {
        if(row == n-1 && col == m-1) {
            ans.add(sb.toString());
        }
        if(row+1 != n && arr[row+1][col] == 1) {
            sb.append("D");
            maze(arr, row+1, col, n, m, sb, ans);
            sb.deleteCharAt(sb.length()-1);
        }
        if(col+1 != m && arr[row][col+1] == 1) {
            sb.append("R");
            maze(arr, row, col+1, n, m, sb, ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}