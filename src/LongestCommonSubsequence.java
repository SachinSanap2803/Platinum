// 1] Recursion

//public class LongestCommonSubsequence {
//    public static void main(String[] args) {
//        String s1 = "abcde";
//        String s2 = "ace";
//
//        System.out.println(LCS(s1.length(), s2.length(), s1, s2));
//    }
//
//    public static int LCS(int l1, int l2, String s1, String s2) {
//        if(l1 == 0 || l2 == 0) {
//            return 0;
//        }
//
//        if(s1.charAt(l1-1) == s2.charAt(l2-1)) {
//            return 1 + LCS(l1-1, l2-1, s1, s2);
//        } else {
//            return Math.max(LCS(l1-1, l2, s1, s2), LCS(l1, l2-1, s1, s2));
//        }
//    }
//}



// 2] Memoization

//import java.util.Arrays;
//
//public class LongestCommonSubsequence {
//    public static void main(String[] args) {
//        String s1 = "abcdexascscdscsdcdc";
//        String s2 = "acexcdcsccdscsds";
//        int l1 = s1.length();
//        int l2 = s2.length();
//
//        int[][] dp = new int[l1+1][l2+1];
//        for (int[] row : dp) {
//            Arrays.fill(row, -1);
//        }
//
//        System.out.println(LCS(l1, l2, s1, s2, dp));
//    }
//
//    public static int LCS(int l1, int l2, String s1, String s2, int[][] dp) {
//        if(dp[l1][l2] != -1) {
//            return dp[l1][l2];
//        }
//
//        if(l1 == 0 || l2 == 0) {
//            return 0;
//        }
//
//        if(s1.charAt(l1-1) == s2.charAt(l2-1)) {
//            dp[l1][l2] =  1 + LCS(l1-1, l2-1, s1, s2, dp);
//        } else {
//            dp[l1][l2] = Math.max(LCS(l1-1, l2, s1, s2, dp), LCS(l1, l2-1, s1, s2, dp));
//        }
//
//        return dp[l1][l2];
//    }
//}




// 3] Tabulation

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";
        int l1 = s1.length();
        int l2 = s2.length();

        int[][] dp = new int[l1+1][l2+1];

        for(int i=1; i<=l1; i++) {
            for(int j=1; j<=l2; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1+dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[l1][l2]);
    }
}