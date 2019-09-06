class Solution {
    public void sortColors(int[] nums) {
        int pivot0 = 0, pivot2 = nums.length - 1;
        for (int i = 0; i <= pivot2; i++) {
            if (nums[i] == 0 && i > pivot0) {
                nums[i] = nums[pivot0];
                nums[pivot0] = 0;
                pivot0++;
                i--;
            } else if (nums[i] == 2 && i < pivot2) {
                nums[i] = nums[pivot2];
                nums[pivot2] = 2;
                pivot2--;
                i--;
            }
        }
    }
}