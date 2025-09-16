import java.util.*;

public class jobScheduling {
    static class Job {
        int start, end, profit;

        public Job(int s, int e, int p) {
            this.start = s;
            this.end = e;
            this.profit = p;
        }
    }

    public int jobSche(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] jobs = new Job[n];

        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }

        // Sort jobs by end time
        Arrays.sort(jobs, Comparator.comparingInt(j -> j.end));

        // dp[i] = max profit taking first i jobs
        int[] dp = new int[n];
        dp[0] = jobs[0].profit;

        for (int i = 1; i < n; i++) {
            int includeProfit = jobs[i].profit;

            // Find the last non-conflicting job using binary search
            int l = binarySearch(jobs, i);
            if (l != -1) {
                includeProfit += dp[l];
            }

            dp[i] = Math.max(dp[i - 1], includeProfit);
        }

        return dp[n - 1];
    }

    // Binary search to find the last job that ends before jobs[index].start
    private int binarySearch(Job[] jobs, int index) {
        int low = 0, high = index - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (jobs[mid].end <= jobs[index].start) {
                if (jobs[mid + 1].end <= jobs[index].start) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}