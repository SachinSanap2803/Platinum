import java.util.Arrays;

public class moveZeroes {
    public static void main(String[] args) {
        int[] arr = {1, 0, 4, 5, 0, 3};

        moveZeroesToLast(arr);

        System.out.println(Arrays.toString(arr));
    }

    static void moveZeroesToLast(int[] arr) {
        int idx = 0;

        for(int num : arr) {
            if(num != 0) {
                arr[idx++] = num;
            }
        }

        while(idx < arr.length) {
            arr[idx++] = 0;
        }
    }
}