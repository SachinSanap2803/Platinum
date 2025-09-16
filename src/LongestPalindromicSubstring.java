public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String str = "babad";
        System.out.println(manachers(str));
    }

    public static String manachers(String str) {
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
        int start = 0;
        int[] p = new int[n];
        int center = 0, right = 0;

        for(int i=1; i<n-1; i++) {
            if(i < right) {
                p[i] = Math.min(right-i, p[2*center-i]);
            }
            while(sChars[i-p[i]-1] == sChars[i+p[i]+1]) {
                p[i]++;
            }
            if(i+p[i] > right) {
                center = i;
                right = i+p[i];
            }
            if(p[i] > maxLen) {
                start = (i-p[i]-1)/2;
                maxLen = p[i];
            }
        }

        return str.substring(start, start+maxLen);
    }
}