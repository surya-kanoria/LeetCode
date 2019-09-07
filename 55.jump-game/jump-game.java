class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length <= 0) {
            return false;
        } else if (nums.length == 1) {
            return true;
        }
        int[] flags = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            flags[i] = 0;
        }
        return getCanJump(nums, 0, flags);
    }

    private boolean getCanJump(int[] nums, int start, int[] flags) {
        if (start >= (nums.length - 1)) {
            return true;
        } else {
            if (flags[start] != 0) {
                return flags[start] == -1 ? false : true;
            } else {
                for (int i = 1; i <= nums[start]; i++) {
                    if (getCanJump(nums, start + i, flags)) {
                        flags[start] = 1;
                        return true;
                    }
                }
                flags[start] = -1;
                return false;
            }
        }
    }
}