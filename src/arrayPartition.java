import java.util.Arrays;

public class arrayPartition {
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 2};

        int maxSum = 0;
        Arrays.sort(arr);

        for(int i=0; i<arr.length; i=i+2) {
            maxSum += arr[i];
        }

        System.out.println("Maximum sum : " + maxSum);
    }
}