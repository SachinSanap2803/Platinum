import java.util.Arrays;

public class missingNumber {
    public static void main(String[] args) {
        int[] arr = {3, 0, 1};
        Arrays.sort(arr);
        int res = missingNum(arr);
        System.out.println("Missing number is " + res);
    }

    public static  int missingNum(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            if(arr[i] != i) {
                return i;
            }
        }

        return arr.length;
    }
}