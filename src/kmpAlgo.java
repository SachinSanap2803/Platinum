// Pattern Matching Algo
public class kmpAlgo {
    public static void main(String[] args) {
        String str = "ABCABCAB";
        String pat = "ABCAB";
        int m = pat.length();
        int[] lps = new int[m];

        patternMatching(str, pat);
    }

    // LPS = Longest Prefix may be possible as Suffix
    public static void computeLPS(String pat, int m, int[] lps) {
        lps[0] = 0;
        int i=1, j=0;
        while (i<m) {
            if(pat.charAt(i) == pat.charAt(j)) {
                j++;
                lps[i] = j;
                i++;
            } else {
                if(j != 0) {
                    j = lps[j-1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    public static void patternMatching(String str, String pat) {
        int len1 = str.length();
        int len2 = pat.length();
        int[] lps = new int[len2];
        computeLPS(pat, len2, lps);

        int i=0, j=0;
        while(i < len1) {
            if(str.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }
            if(j == len2) {
                System.out.print(i-j + " ");
                j = lps[j-1];
            } else if(i<len1 && str.charAt(i) != pat.charAt(j)){
                if(j != 0) {
                    j = lps[j-1];
                } else {
                    i++;
                }
            }
        }
    }
}