class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (coins == null || coins.length <= 0) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        int res = getCoinChange(dp, amount, coins);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int getCoinChange(int[] dp, int target, int[] coins) {
        if (target == 0) {
            return 0;
        } else if (target < 0) {
            return Integer.MAX_VALUE;
        } else {
            if (dp[target] != -1) {
                return dp[target];
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < coins.length; i++) {
                min = Math.min(min, getCoinChange(dp, target - coins[i], coins));
            }
            if (min == Integer.MAX_VALUE) {
                dp[target] = Integer.MAX_VALUE;
                return Integer.MAX_VALUE;
            }
            dp[target] = min + 1;
            return min + 1;
        }
    }
}