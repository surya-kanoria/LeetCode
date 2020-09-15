class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        return moneyAmount(1, n, dp);
    }

    public int moneyAmount(int start, int end, int[][] dp) {
        if (start >= end) {
            return 0;
        } else if (dp[start][end] > 0) {
            return dp[start][end];
        }
        int min = end + 1;
        for (int i = start + 1; i <= end; i++) {
            min = Math.min(min, i + Math.max(moneyAmount(i + 1, end, dp), moneyAmount(start, i - 1, dp)));
        }
        dp[start][end] = min;
        return min;
    }
}