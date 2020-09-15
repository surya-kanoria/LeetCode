class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int[] rightSum = new int[cardPoints.length + 1];
        int tot = 0;
        rightSum[cardPoints.length] = 0;
        for (int i = cardPoints.length - 1; i >= 0; i--) {
            tot = tot + cardPoints[i];
            rightSum[i] = tot;
        }
        int max = Integer.MIN_VALUE;
        int leftSum = 0;
        for (int i = 0; i <= k && i < cardPoints.length; i++) {
            max = Math.max(leftSum + rightSum[cardPoints.length - (k - i)], max);
            System.out.println(i + " --> " + max);
            leftSum = leftSum + cardPoints[i];
        }
        return max;
    }
}