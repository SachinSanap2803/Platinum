public class firstMissingNum {
    public static void main(String[] args) {
        int[] arr = {2, 7, 9, 3, 4, 8};

        int missing = missingNumber(arr);
        System.out.println("Missing number in the array is " + missing);
    }

    public static int missingNumber(int[] arr) {
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<n; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
            if(arr[i] < min) {
                min = arr[i];
            }
        }

        int range = max-min+1;
        int[] newArray = new int[range];

        for(int i=0; i<n; i++) {
            newArray[arr[i] - min]++;
        }

        for(int i=0; i<range; i++) {
            if(newArray[i] == 0) {
                return i+min;
            }
        }

        return 0;
    }
}