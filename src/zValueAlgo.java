// Pattern Matching Algo
public class zValueAlgo {
    public static void main(String[] args) {
        String str = "ABCABD";
        String pat = "AB";

        zValue(str, pat);
    }

    public static void zValue(String str, String pat) {
        String newStr = pat + "$" + str;
        int n = newStr.length();
        int m = pat.length();
        int[] zArr = new int[n];

        computeArray(newStr, zArr, m);

        for(int i=m+1; i<n; i++) {
            if(zArr[i] == m) {
                System.out.print(i-(m+1) + "  ");
            }
        }
    }

    public static void computeArray(String str, int[] arr, int len) {
        for(int i=len+1; i<str.length(); i++) {
            while(str.charAt(arr[i]) == str.charAt(i+arr[i])) {
                arr[i]++;
            }
        }
    }
}