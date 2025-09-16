// Brute Force

//public class EditDistance {
//    public static void main(String[] args) {
//        String word1 = "intention";
//        String word2 = "execution";
//        int l1 = word1.length();
//        int l2 = word2.length();
//
//        System.out.println(minDistance(word1, word2, l1, l2));
//    }
//
//    public static int minDistance(String s1, String s2, int l1, int l2) {
//        if(l1 == 0) {
//            return l2;
//        }
//        if(l2 == 0) {
//            return l1;
//        }
//
//        if(s1.charAt(l1-1) == s2.charAt(l2-1)) {
//            return minDistance(s1, s2, l1-1, l2-1);
//        }
//
//        return 1 + Math.min(minDistance(s1, s2, l1, l2-1), Math.min(minDistance(s1, s2, l1-1, l2), minDistance(s1, s2, l1-1, l2-1)));
//    }
//}




// Memoization

public class EditDistance {
    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        int l1 = word1.length();
        int l2 = word2.length();

        int[][] dp = new int[l1+1][l2+1];
        for(int i=0; i<=l1; i++) {
            for(int j=0; j<=l2; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(minDistance(word1, word2, l1, l2, dp));
    }

    public static int minDistance(String s1, String s2, int l1, int l2, int[][] dp) {
        if(l1 == 0) {
            return l2;
        }
        if(l2 == 0) {
            return l1;
        }
        if(dp[l1][l2] != -1) {
            return dp[l1][l2];
        }

        if(s1.charAt(l1-1) == s2.charAt(l2-1)) {
            return dp[l1][l2] = minDistance(s1, s2, l1-1, l2-1, dp);
        }

        return dp[l1][l2] = 1 + Math.min(minDistance(s1, s2, l1, l2-1, dp), Math.min(minDistance(s1, s2, l1-1, l2, dp), minDistance(s1, s2, l1-1, l2-1, dp)));
    }
}