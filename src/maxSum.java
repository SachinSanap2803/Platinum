public class maxSum {
    public static void main(String[] args) {
        int[] arr = {5, 1, 7, 8, 2};
        int max = 0;

        for(int i=0; i<arr.length-1; i++) {
            for(int j=i+1; j<arr.length; j++) {
                int currSum = arr[i] + arr[j];
                max = Math.max(max, currSum);
            }
        }

        System.out.println(max);
    }
}