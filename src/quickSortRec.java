import java.util.Arrays;

public class quickSortRec {
    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 3, 6, 8};
        quickSort(arr, 0, arr.length-1);

        System.out.println("Sorted Array " + Arrays.toString(arr));
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low+1;
        int j = high;

        while(i <= j) {
            while(i <= high && arr[i] <= pivot) {
                i++;
            }

            while(j >= low && arr[j] > pivot) {
                j--;
            }

            if(i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, low, j);
        return j;
    }

    public static void quickSort(int[] arr, int low, int high) {
        if(low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
