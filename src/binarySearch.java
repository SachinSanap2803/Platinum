public class binarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int target = 4;

        System.out.println("Target " + target + " found at index " + BS(arr, target));
    }

    static int BS(int[] arr, int target) {
        int left = 0;
        int right = arr.length-1;

        while(left <= right) {
            int mid = left + (right-left)/2;

            if(arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid-1;
            }
        }
        return 0;
    }
}