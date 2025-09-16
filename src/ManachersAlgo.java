// Longest Palindromic Substring
public class ManachersAlgo {
    public static void main(String[] args) {
        String str = "AKA";
        System.out.println(manachers(str));
    }

    public static int manachers(String str) {
        int n = 2 * str.length() + 3;
        char[] sChars = new char[n];
        sChars[0] = '@';
        sChars[n-1] = '&';
        int t = 1;

        for(int i=0; i<str.length(); i++) {
            sChars[t++] = '#';
            sChars[t++] = str.charAt(i);
        }
        sChars[t] = '#';

        int maxLen = 1;
        int[] p = new int[n];

        for(int i=1; i<n-1; i++) {
            while(sChars[i-p[i]-1] == sChars[i+p[i]+1]) {
                p[i]++;
            }
            if(p[i] > maxLen) {
                maxLen = p[i];
            }
        }

        return maxLen;
    }
}