import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                ArrayList arrayList = map.get((nums[i]));
                arrayList.add((i));
            } else {
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(i);
                map.put(nums[i], arrayList);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int remain = target - nums[i];
            if (map.containsKey(remain)) {
                int[] solution = new int[2];
                ArrayList<Integer> arrayList = map.get(remain);
                if (nums[i] == remain) {
                    if (arrayList.size() > 1) {
                        solution[0] = arrayList.get(0);
                        solution[1] = arrayList.get(1);
                    } else {
                        continue;
                    }
                } else {
                    solution[0] = i;
                    solution[1] = arrayList.get(0);
                }
                return solution;
            }
        }
        return null;
    }
}