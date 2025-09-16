public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        String s = "abab";
        System.out.println(repeatedSubs(s));
    }

    public static boolean repeatedSubs(String s) {
        int n = s.length();
        int[] lps = new int[n];

        for(int i=1, j=0; i<n; ) {
            if(s.charAt(i) == s.charAt(j)) {
                lps[i++] = ++j;
            } else if (j>0) {
                j = lps[j-1];
            } else {
                lps[i++] = 0;
            }
        }
        int j = lps[n-1];

        return (j>0 && n%(n-j) == 0);
    }
}