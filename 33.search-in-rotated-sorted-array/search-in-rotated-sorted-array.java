class Solution {
    public int search(int[] nums, int target) {
        if (nums.length <= 0) {
            return -1;
        } else if (nums.length == 1) {
            return (nums[0] == target ? 0 : -1);
        }
        int low = 0, high = nums.length - 1;
        int mid = (low + high) / 2;
        while (low <= high) {
            if (nums[mid] >= nums[low] && nums[mid] <= nums[high]) {
                break;
            } else if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            mid = (low + high) / 2;
        }
        int index = low;
        int length = nums.length - 1;
        high = nums.length - 1 + low;
        System.out.println(index + "," + high);
        do {
            System.out.println(low + "," + high);
            mid = (low + high) / 2;
            if (nums[mid % length] > target) {
                high = mid - 1;
            } else if (nums[mid % length] < target) {
                low = mid + 1;
            } else {
                return (mid % length);
            }
        } while (low <= high);
        return -1;
    }
}