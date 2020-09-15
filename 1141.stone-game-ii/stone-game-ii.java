class Solution {
    public int stoneGameII(int[] piles) {
        int[] cumSum = new int[piles.length + 1];
        cumSum[piles.length] = 0;
        int sum = 0;
        for (int i = piles.length - 1; i >= 0; i--) {
            sum = sum + piles[i];
            cumSum[i] = sum;
        }
        int[][] dp = new int[piles.length][piles.length];
        return getMaxStoneForPlayer(piles, cumSum, 0, 1, dp);
    }

    public int getMaxStoneForPlayer(int[] piles, int[] cumSum, int currentIndex, int M, int[][] dp) {
        if (currentIndex >= piles.length) {
            return 0;
        }
        if (dp[currentIndex][M] > 0) {
            return dp[currentIndex][M];
        }
        int max = 0;
        int newTotal = 0;
        for (int i = currentIndex; i < (2 * M) + currentIndex && i < piles.length; i++) {
            newTotal = newTotal + piles[i];
            int stonesForOpp = getMaxStoneForPlayer(piles, cumSum, i + 1, Math.max(M, (i - currentIndex + 1)), dp);
            max = Math.max(max, newTotal + (cumSum[i + 1] - stonesForOpp));

        }
        dp[currentIndex][M] = max;
        return max;
    }
}