class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList();
        if (nums == null || nums.length <= 0) {
            if (lower <= upper) {
                res.add(getString(lower, upper + 1));
                return res;
            }
        }
        if (lower < nums[0]) {
            res.add(getString(lower, nums[0]));
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1] + 1 && nums[i - 1] != Integer.MAX_VALUE) {
                res.add(getString(nums[i - 1] + 1, nums[i]));
            }
        }
        if (nums[nums.length - 1] < upper) {
            res.add(getString(nums[nums.length - 1] + 1, upper + 1));
        }
        return res;
    }

    private String getString(int lower, int upper) {
        if (lower + 1 == upper) {
            return String.valueOf(lower);
        } else {
            return String.valueOf(lower) + "->" + String.valueOf(upper - 1);
        }
    }
}