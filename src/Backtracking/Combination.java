package Backtracking;

public class Combination {
    public static void main(String[] args) {
        String[] arr = {"B1", "B2", "G"};
        arrangements(arr, 0);
    }

    public static void arrangements(String[] arr, int idx) {
        if(idx == arr.length) {
            if(!arr[1].equals("G")) {
                for(String s : arr) {
                    System.out.print(s + " ");
                }
                System.out.println();
            }
        }

        for(int i=idx; i<arr.length; i++) {
            swap(arr, i, idx);
            arrangements(arr, idx+1);
            swap(arr, i, idx);
        }
    }

    public static void swap(String[] arr, int i, int idx) {
        String temp = arr[i];
        arr[i] = arr[idx];
        arr[idx] = temp;
    }
}