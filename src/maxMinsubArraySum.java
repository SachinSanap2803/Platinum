public class maxMinsubArraySum {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        int w = 3;
        System.out.println(subArraySum(arr, w));
    }

    public static int subArraySum(int[] arr, int w) {
        int sum = 0;
        int n = arr.length;

        for(int i=0; i<n-w+1; i++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int j=i; j<i+w; j++) {
                if(min > arr[j]) {
                    min = arr[j];
                }
                if(max < arr[j]) {
                    max = arr[j];
                }
            }
            sum += min + max;
        }

        return sum;
    }
}