public class secMax {
    public static void main(String[] args) {
        int[] arr = {1, 6, 7, 0, 2};
        int max = Integer.MIN_VALUE;
        int secMax = Integer.MAX_VALUE;

        System.out.println("Second largest element in an array is : " + secLargest(arr, max, secMax));
    }

    static int secLargest(int[] arr, int max, int secMax) {
        for(int i=0; i<arr.length; i++) {
            if(arr[i] > max) {
                secMax = max;
                max = arr[i];
            } else if (arr[i] > secMax && arr[i] < max) {
                secMax = arr[i];
            }
        }

        return secMax;
    }
}