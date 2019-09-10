class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }
        return getNumSquares(n, dp);
    }

    private int getNumSquares(int n, int[] dp) {
        int sqrt = (int) (Math.floor(Math.sqrt(n)));
        if (dp[n] != -1) {
            return dp[n];
        }
        if (n == 0) {
            return 0;
        } else if (n < 0) {
            return Integer.MAX_VALUE;
        }
        int min = Integer.MAX_VALUE;
        for (int i = sqrt; i >= 1; i--) {
            min = Math.min(min, getNumSquares(n - (i * i), dp));
        }
        dp[n] = min + 1;
        return min + 1;
    }
}