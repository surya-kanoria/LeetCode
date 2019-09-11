class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        if (nums == null || nums.length <= 0) {
            return true;
        }
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        int[] dp = new int[(sum * 2) + 1];
        dp[sum + nums[0]] = 1;
        dp[sum - nums[0]] = 1;
        for (int j = 1; j < nums.length; j++) {
            int[] newDp = new int[(sum * 2) + 1];
            for (int i = 0; i < dp.length; i++) {
                if (dp[i] != 0) {
                    newDp[(i + nums[j])] = 1;
                    newDp[(i - nums[j])] = 1;
                }
            }
            dp = newDp;
        }
        return dp[sum] == 1;
    }
}