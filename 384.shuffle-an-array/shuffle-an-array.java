class Solution {
    private Random random;
    private int[] nums;

    public Solution(int[] nums) {
        this.random = new Random();
        this.nums = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        ArrayList list = new ArrayList();
        int[] copy = new int[nums.length];
        int ind = 0;
        for (int i = 0; i < this.nums.length; i++) {
            while ((ind = this.random.nextInt(this.nums.length)) < 0 || copy[ind] != 0)
                continue;
            copy[ind] = this.nums[i];
        }
        return copy;
    }
}

/**
 * Your Solution object will be instantiated and called as such: Solution obj =
 * new Solution(nums); int[] param_1 = obj.reset(); int[] param_2 =
 * obj.shuffle();
 */