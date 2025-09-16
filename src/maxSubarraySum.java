public class maxSubarraySum {
    public static void main(String[] args) {
        int[] arr = {5, 2, 6, 7, 1, 12, 4};
        int size = 4;
        int n = arr.length;

        int windowSum = 0;

        for(int i=0; i<size; i++) {
            windowSum += arr[i];
        }

        int maxSum = windowSum;

        for(int i=size; i<n; i++) {
            windowSum +=  arr[i] - arr[i-size];
            maxSum = Math.max(maxSum, windowSum);
        }

        System.out.println(maxSum);
    }
}