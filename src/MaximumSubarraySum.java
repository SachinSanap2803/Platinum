public class MaximumSubarraySum {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int maxSum = arr[0];
        int currSum = arr[0];

        for(int i=1; i<arr.length; i++) {
            if(currSum + arr[i] > arr[i]) {
                currSum += arr[i];
            } else {
                currSum = arr[i];
            }
            maxSum = Math.max(maxSum, currSum);
        }

        System.out.println(maxSum);
    }
}