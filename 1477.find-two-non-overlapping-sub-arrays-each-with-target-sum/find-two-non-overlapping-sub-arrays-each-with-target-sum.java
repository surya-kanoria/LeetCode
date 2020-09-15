//[3,2,2,4,3]
class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        return getMinSumOfLengths(arr, target, 0, new int[arr.length]);
    }

    private int getMinSumOfLengths(int[] arr, int target, int pos, int[] dp) {
        if (pos >= arr.length) {
            return -1;
        } else if (dp[pos] > 0) {
            return dp[pos];
        }
        int start = pos, end = pos;
        int sum = 0;
        while (end < arr.length) {
            sum = sum + arr[end];
            if (sum < target) {
                end++;
            } else if (sum > target) {
                while (sum > target && start <= end) {
                    sum = sum - arr[start];
                    start++;
                }
            }
            if (sum == target) {
                int currentLength = end - start + 1;
                dp[pos] = currentLength + Math.min(getMinSumOfLengths(arr, target, end + 1, dp),
                        getMinSumOfLengths(arr, target, start + 1, dp));
                return dp[pos];
            }
        }
        return -1;
    }
}