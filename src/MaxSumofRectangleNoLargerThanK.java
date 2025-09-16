import java.util.HashSet;
import java.util.Set;

public class MaxSumofRectangleNoLargerThanK {
    public static void main(String[] args) {
        int[][] matrix = {{1,0,1},{0,-2,3}};
        int k = 2;

        int rows = matrix.length;
        int cols = matrix[0].length;
        int res = Integer.MIN_VALUE;

        for(int left = 0; left < cols; left++) {
            int[] rowSum = new int[rows];

            for(int right = left; right < cols; right++) {
                for(int r=0; r<rows; r++) {
                    rowSum[r] += matrix[r][right];
                }

                Set<Integer> prefixSet = new HashSet<>();
                prefixSet.add(0);
                int currSum = 0;
                for(int sum: rowSum) {
                    currSum += sum;

                }
            }
        }
    }
}