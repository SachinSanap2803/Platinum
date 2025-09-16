// Brute force

//public class Knapsack_0_1 {
//    public static void main(String[] args) {
//        int[] profit = {40, 50, 120};
//        int[] weight = {4, 8, 16};
//        int sack = 24;
//        int n = profit.length;
//
//        System.out.println(knapsack(sack, weight, profit, n));
//    }
//
//    public static int knapsack(int s, int[] wt, int[] pr, int n) {
//        if(n == 0 || s == 0) {
//            return 0;
//        }
//
//        if(wt[n-1] > s) {
//            return knapsack(s, wt, pr, n-1);
//        } else {
//            return Math.max(knapsack(s, wt, pr, n-1), pr[n-1] + knapsack(s-wt[n-1], wt, pr, n-1));
//        }
//    }
//}





// Optimized with Memomization

//public class Knapsack_0_1 {
//    public static void main(String[] args) {
//        int[] profit = {40, 50, 120};
//        int[] weight = {4, 8, 16};
//        int sack = 24;
//        int n = profit.length;
//        int[][] dp = new int[n+1][sack+1];
//        for(int i=0; i<=n; i++) {
//            for(int j=0; j<=sack; j++) {
//                dp[i][j] = -1;
//            }
//        }
//
//        System.out.println(knapsack(sack, weight, profit, n, dp));
//    }
//
//    public static int knapsack(int s, int[] wt, int[] pr, int n, int[][] dp) {
//        if(n == 0 || s == 0) {
//            return 0;
//        }
//        if(dp[n][s] != -1) {
//            return dp[n][s];
//        }
//        if(wt[n-1] > s) {
//            return dp[n][s] = knapsack(s, wt, pr, n-1, dp);
//        } else {
//            return dp[n][s] = Math.max(knapsack(s, wt, pr, n-1, dp), pr[n-1] + knapsack(s-wt[n-1], wt, pr, n-1, dp));
//        }
//    }
//}




// Tabulation

public class Knapsack_0_1 {
    public static void main(String[] args) {
        int[] profit = {40, 50, 120};
        int[] weight = {4, 8, 16};
        int sack = 24;
        int n = profit.length;
        int[][] dp = new int[n+1][sack+1];

        knapsack(sack, weight, profit, n, dp);
    }

    public static void knapsack(int s, int[] wt, int[] pr, int n, int[][] dp) {
        for(int i=0; i<=n; i++) {
            for(int j=0; j<=s; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if(wt[i-1] <= j) {
                    dp[i][j] = Math.max(dp[i-1][j], pr[i-1]+dp[i-1][j-wt[i-1]]);
                } else {
                    dp[i][j] = dp[i-1][j];       // Exclude Product
                }
            }
        }

        System.out.println(dp[n][s]);
    }
}