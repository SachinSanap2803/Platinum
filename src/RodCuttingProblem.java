public class RodCuttingProblem {
    public static void main(String[] args) {
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        int n = price.length;
        int idx = n-1;

        System.out.println(rodCutting(price, idx, n));
    }

    public static int rodCutting(int[] arr, int idx, int n) {
        if(idx == 0) {
            return n * arr[0];
        }

        int notCut = rodCutting(arr, idx-1, n);
        int cut = Integer.MIN_VALUE;
        int rodLength = idx+1;

        if(rodLength <= n) {
            cut = arr[idx] + rodCutting(arr, idx, n-rodLength);
        }

        return Math.max(notCut, cut);
    }
} 