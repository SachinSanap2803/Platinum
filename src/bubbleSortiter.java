import java.util.Arrays;

public class bubbleSortiter {
    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 3, 6, 8};
        int[] sort = bubbleSort(arr);

        System.out.println("Sorted Array : " + Arrays.toString(arr));
    }

    public static int[] bubbleSort(int[] arr) {
        int n = arr.length;

        for(int i=0; i<n-1; i++) {

            for(int j=0; j<n-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        return arr;
    }
}