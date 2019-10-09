class Solution {
    public int trap(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int leftMax = 0;
        int rightMax = 0;
        for (int i = 0; i < nums.length; i++) {
            left[i] = leftMax;
            leftMax = Math.max(leftMax, nums[i]);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            right[i] = rightMax;
            rightMax = Math.max(rightMax, nums[i]);
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int min = Math.min(right[i], left[i]);
            if (min > nums[i]) {
                count = count + (min - nums[i]);
            }
        }
        return count;
    }
}