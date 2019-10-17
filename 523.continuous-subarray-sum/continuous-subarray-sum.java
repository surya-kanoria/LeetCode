import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length <= 0) {
            return false;
        }
        HashMap<Integer, Integer> remainder = new HashMap<>();
        remainder.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (k != 0) {
                sum = sum % k;
            }
            if (remainder.containsKey(sum)) {
                int remainingSumIndex = remainder.getOrDefault(sum, i);
                if (i - remainingSumIndex > 1) {
                    return true;
                }
            } else {
                remainder.put(sum, i);
            }
        }
        return false;
    }
}