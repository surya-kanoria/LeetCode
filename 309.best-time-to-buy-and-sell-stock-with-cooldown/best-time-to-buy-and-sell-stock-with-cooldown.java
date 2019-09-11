class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 0) {
            return 0;
        }
        // nothing
        int[] state1 = new int[prices.length];
        // bought
        int[] state2 = new int[prices.length];
        // cooling period
        int[] state3 = new int[prices.length];
        state1[0] = 0;
        state2[0] = (-1 * prices[0]);
        state3[0] = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            state1[i] = Math.max(state1[i - 1], state3[i - 1]);
            state2[i] = Math.max(state2[i - 1], (state1[i - 1] - prices[i]));
            state3[i] = Math.max((state2[i - 1] + prices[i]), state3[i - 1]);
        }
        return Math.max(state1[prices.length - 1], state3[prices.length - 1]);
    }
}