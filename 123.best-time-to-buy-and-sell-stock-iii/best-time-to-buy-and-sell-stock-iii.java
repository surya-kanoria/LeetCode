class Solution {
    public int maxProfit(int[] prices) {
        int[] diffPrices = new int[prices.length - 1];
        for (int i = 0; i < prices.length - 1; i++) {
            diffPrices[i] = prices[i + 1] - prices[i];
        }
        int max = 0;
        int sum = 0;
        int maxStart = 0, maxEnd = 0;
        int start = -1, end = -1;
        for (int i = 0; i < diffPrices.length; i++) {
            if (sum + diffPrices[i] > 0) {
                sum = sum + diffPrices[i];
                end = i;
            } else {
                if (sum > max) {
                    max = sum;
                    maxStart = start;
                    maxEnd = end;
                }
                sum = 0;
            }
        }
        if (sum > max) {
            max = sum;
            maxStart = start;
            maxEnd = end;
        }
        if (max <= 0) {
            return 0;
        } else {
            int max2 = 0;
            sum = 0;
            for (int i = 0; i < maxStart; i++) {
                if (sum + diffPrices[i] > 0) {
                    sum = sum + diffPrices[i];
                    end = i;
                } else {
                    max2 = Math.max(max2, sum);
                    sum = 0;
                }
            }
        }
    }
}