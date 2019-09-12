import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return null;
        }
        return getPermutations(nums, new HashSet<>());
    }

    private List<List<Integer>> getPermutations(int[] nums, HashSet<Integer> set) {
        if (nums.length == set.size()) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(i)) {
                set.add(i);
                List<List<Integer>> list = getPermutations(nums, set);
                if (list == null) {
                    List<Integer> singleList = new ArrayList();
                    singleList.add(nums[i]);
                    res.add(singleList);
                } else {
                    for (List<Integer> singleList : list) {
                        singleList.add(nums[i]);
                        res.add(singleList);
                    }
                }
                set.remove(i);
            }
        }
        return res;
    }
}