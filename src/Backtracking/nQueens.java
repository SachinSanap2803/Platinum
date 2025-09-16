package Backtracking;

public class nQueens {
    static boolean flag;

    public static void main(String[] args) {
        int n = 4;
        int[][] board = new int[n][n];
        buildBoard(board, 0);
    }

    public static void buildBoard(int[][] board, int row) {
        if(row == board.length) {
            if(!flag) {
                flag = true;
                printBoard(board);
            }
            return;
        }
        for(int col=0; col<board.length; col++) {
            if(isSafe(board, row, col)) {
                board[row][col] = 1;
                buildBoard(board, row+1);
                board[row][col] = 0;
            }
        }
    }

    public static boolean isSafe(int[][] board, int row, int col) {
        // Upper left
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
            if(board[i][j] == 1) {
                return false;
            }
        }

        // Upper
        for(int i=0; i<row; i++) {
            if(board[i][col] == 1) {
                return false;
            }
        }

        // Upper right
        for(int i=row-1, j=col+1; i>=0 && j<board.length; i--, j++) {
            if(board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    public static void printBoard(int[][] board) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board.length; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println(" ------ ");
    }
}