public class RearrangeArrayElementsBySign {
    public static void main(String[] args) {
        int[] arr = {3,1,-2,-5,2,-4};

        int n = arr.length;
        int[] ans = new int[n];
        int pos = 0;
        int neg = 1;

        for(int num : arr) {
            if(num > 0) {
                ans[pos] = num;
                pos = pos + 2;
            } else {
                ans[neg] = num;
                neg = neg + 2;
            }
        }

        for(int num : ans) {
            System.out.print(num + " ");
        }
    }
}