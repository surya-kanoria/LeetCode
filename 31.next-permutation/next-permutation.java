class Solution {
    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[(i - 1)]) {
                int temp = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = temp;
                return;
            }
        }
        for (int i = 0; i < (nums.length / 2); i++) {
            int pos = (nums.length - 1 - i);
            int temp = nums[i];
            nums[i] = nums[pos];
            nums[pos] = temp;
        }
    }
}