class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        return getPeakElement(nums, 0, nums.length - 1);
    }

    private int getPeakElement(int[] nums, int low, int high) {
        int mid = (low + high) / 2;
        if ((getElement(nums, mid) > getElement(nums, mid + 1))
                && (getElement(nums, mid) > getElement(nums, mid - 1))) {
            return mid;
        } else if (getElement(nums, mid) < getElement(nums, mid + 1)) {
            return getPeakElement(nums, mid + 1, high);
        } else {
            return getPeakElement(nums, low, mid - 1);
        }
    }

    private long getElement(int[] nums, int index) {
        if (index < 0 || index >= nums.length) {
            return Long.MIN_VALUE;
        } else {
            return nums[index];
        }
    }
}