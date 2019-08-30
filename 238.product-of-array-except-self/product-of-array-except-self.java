class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] sol = new int[nums.length];
        int prod = 1;
        for (int i = 0; i < nums.length; i++) {
            sol[i] = prod;
            prod = prod * nums[i];
        }
        prod = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            sol[i] = sol[i] * prod;
            prod = prod * nums[i];
        }
        return sol;
    }
}