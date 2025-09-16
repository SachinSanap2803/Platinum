public class LongestPalindromSub {
    public static void main(String[] args) {
        String str = "babad";
        String ans = longestPalindrome(str);
        System.out.println("Longest Substring in " + str + " is " + ans);
    }

    public static String longestPalindrome(String s) {
        int maxLen = 0;
        String sb = "";

        for(int i=0; i<s.length(); i++) {
            for(int j=i; j<s.length(); j++) {
                String sub = s.substring(i, j+1);
                if(isPalindrome(sub) && sub.length() > maxLen) {
                    sb = sub;
                    maxLen = sub.length();
                }
            }
        }

        return sb.toString();
    }

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;

        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
