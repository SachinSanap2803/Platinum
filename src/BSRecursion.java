public class BSRecursion {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int target = 5;

        int result = BS(arr, target, 0, arr.length-1);
        if(result != -1) {
            System.out.println("Element " + target + " found at index " + result);
        } else {
            System.out.println("Element " + target + " not found");
        }
    }

    static int BS(int[] arr, int target, int left, int right) {
        if(left > right) {
            return -1;
        }

        int mid = left + (right-left)/2;

        if(arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return BS(arr, target, mid+1, right);
        } else {
            return BS(arr, target, left, mid-1);
        }
    }
}