class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxCount = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                continue;
            }
            int left = map.getOrDefault(nums[i] - 1, 0);
            int right = map.getOrDefault(nums[i] + 1, 0);
            map.put(nums[i], left + right + 1);
            maxCount = Math.max(maxCount, map.get(nums[i]));
            map.put(nums[i] - left, left + right + 1);
            map.put(nums[i] + right, left + right + 1);
        }
        return maxCount;
    }
}