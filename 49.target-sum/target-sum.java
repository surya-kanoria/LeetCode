import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        if (S > sum || S < (-1 * sum)) {
            return 0;
        }
        int[] dp = new int[(2 * sum) + 1];
        dp[0 + sum] = 1;
        for (int i = 0; i < nums.length; i++) {
            int[] newDp = new int[(2 * sum) + 1];
            for (int j = 0; j < dp.length; j++) {
                if (dp[j] != 0) {
                    newDp[j + nums[i]] = newDp[j + nums[i]] + dp[j];
                    newDp[j - nums[i]] = newDp[j - nums[i]] + dp[j];
                }
            }
            dp = newDp;
        }
        return dp[S + sum];
    }
}