class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return new int[0];
        }
        int[] right = new int[nums.length];
        int[] left = new int[nums.length];
        int[] res = new int[nums.length];
        int prod = 1;
        for (int i = 0; i < nums.length; i++) {
            left[i] = prod;
            prod = prod * nums[i];
        }
        prod = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            right[i] = prod;
            prod = prod * nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }
}