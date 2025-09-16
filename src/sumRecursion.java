public class sumRecursion {
    public static void main(String[] args) {
        int[] arr = {5, 2, 6, 2, 1};
        int n = arr.length;

        System.out.println(Sum(arr, n-1, 0));
    }

    static int Sum(int[] arr, int n, int sum) {
        if(n < 0) {
            return sum;
        }

        sum = sum + arr[n];
        return Sum(arr, n-1, sum);
    }
}