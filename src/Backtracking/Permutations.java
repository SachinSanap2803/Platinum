package Backtracking;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        arrangements(nums, 0);
    }

    public static void arrangements(int[] arr, int idx) {
        if(idx == arr.length) {
            for(int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        for(int i=idx; i<arr.length; i++) {
            swap(arr, i, idx);
            arrangements(arr, idx+1);
            swap(arr, i, idx);
        }
    }

    public static void swap(int[] arr, int i, int idx) {
        int temp = arr[i];
        arr[i] = arr[idx];
        arr[idx] = temp;
    }
}