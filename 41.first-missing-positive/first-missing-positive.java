class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] >= 0 && (nums[i] < nums.length) && nums[i] != i && nums[nums[i]] != nums[i]) {
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
                System.out.println(temp + "," + nums[i]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length == nums[0] ? nums.length + 1 : nums.length;
    }
}