class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int small = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        int previousSmall = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < small) {
                previousSmall = small;
                small = nums[i];
            } else if (small != Integer.MIN_VALUE && nums[i] > small && nums[i] < mid) {
                mid = nums[i];
            } else if (small != Integer.MIN_VALUE && mid != Integer.MIN_VALUE && nums[i] > mid) {
                return true;
            }
        }
        return false;
    }
}