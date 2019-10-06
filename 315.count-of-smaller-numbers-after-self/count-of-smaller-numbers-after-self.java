class Solution {
    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return new ArrayList();
        }
        int[][] count = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            count[i][1] = 0;
            count[i][0] = i;
        }
        getSmallerCount(0, nums.length - 1, nums, count);
        List<Integer> res = new ArrayList(nums.length);
        int[] sol = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sol[count[i][0]] = count[i][1];
        }
        for (int i = 0; i < nums.length; i++) {
            res.add(sol[i]);
        }
        return res;
    }

    private void getSmallerCount(int start, int end, int[] nums, int count[][]) {
        if (start == end) {
            count[start][1] = 0;
            return;
        }
        int mid = (start + end) / 2;
        getSmallerCount(start, mid, nums, count);
        getSmallerCount(mid + 1, end, nums, count);
        int right = mid + 1;
        for (int i = start; i <= mid; i++) {
            while (right <= end && nums[count[i][0]] <= nums[count[right][0]]) {
                right++;
            }
            if (right <= end) {
                count[i][1] = (end - right + 1) + count[i][1];
            }
        }
        int left = start;
        right = mid + 1;
        int[][] merged = new int[end - start + 1][2];
        int merge = 0;
        while (left <= mid && right <= end) {
            if (nums[count[left][0]] <= nums[count[right][0]]) {
                merged[merge] = count[right];
                right++;
            } else {
                merged[merge] = count[left];
                left++;
            }
            merge++;
        }
        while (left <= mid) {
            merged[merge] = count[left];
            left++;
            merge++;
        }
        while (right <= end) {
            merged[merge] = count[right];
            right++;
            merge++;
        }
        for (int i = start; i <= end; i++) {
            count[i] = merged[i - start];
        }
    }
}