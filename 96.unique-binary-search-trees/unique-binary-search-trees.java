class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        return getNumTrees(n, dp);
    }

    private int getNumTrees(int n, int[] dp) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + (getNumTrees(i, dp) * getNumTrees(n - 1 - i, dp));
        }
        dp[n] = sum;
        return sum;
    }
}