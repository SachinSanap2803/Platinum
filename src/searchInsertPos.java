public class searchInsertPos {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5};
        int target = 1;

        int ans = searchPos(arr, target);

        System.out.println("position of " + target + " is " + ans);
    }

    public static int searchPos(int[] arr, int target) {
        int left = 0;
        int right = arr.length-1;

        while(left <= right) {
            int mid = left + (right - left)/2;

            if(arr[mid] == target) {
                return mid;
            } else if(arr[mid] > target) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return -1;
    }
}