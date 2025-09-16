public class MaxAdjaDiff {
    public static void main(String[] args) {
        int[] arr = {2, 1, 11, 4, 8, 20};

        System.out.println(calDiff(arr));
    }

    public static int calDiff(int[] arr) {
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

        int maxDiff = 0;
        int left = -1;
        for(int i=0; i<range; i++) {
            if(left == -1 && newArray[i] != 0) {
                left = i;
            } else if(newArray[i] != 0) {
                int tempDiff = i - left;
                if(tempDiff > maxDiff) {
                    maxDiff = tempDiff;
                }
                left = i;
            }
        }

        return maxDiff;
    }
}