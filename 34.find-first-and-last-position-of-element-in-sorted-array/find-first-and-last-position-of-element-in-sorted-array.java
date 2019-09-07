class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length <= 0) {
            return getSolution(-1, -1);
        }
        int mid = getSearchedPosition(nums, target, 0, nums.length - 1);
        if (mid == -1) {
            return getSolution(-1, -1);
        }
        int low = mid, high = mid;
        System.out.println(mid);
        do {
            int res = getSearchedPosition(nums, target, 0, low - 1);
            if (res == -1) {
                break;
            } else {
                low = res;
            }
        } while (low > 0);
        do {
            int res = getSearchedPosition(nums, target, high + 1, nums.length - 1);
            if (res == -1) {
                break;
            } else {
                high = res;
            }
        } while (high > 0 && high < nums.length - 1);
        return getSolution(low, high);
    }

    private int[] getSolution(int low, int high) {
        int[] sol = new int[2];
        sol[0] = low;
        sol[1] = high;
        return sol;
    }

    private int getSearchedPosition(int[] nums, int target, int low, int high) {
        do {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                System.out.println(low + "," + high + "," + mid);
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        } while (low <= high && low >= 0 && high >= 0);
        System.out.println(low + "," + high);
        return -1;
    }
}