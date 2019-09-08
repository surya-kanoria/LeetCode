import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int count = map.get(nums[i]);
                map.replace(nums[i], count, count + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> (b.getValue() - a.getValue()));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.add(entry);
        }
        List<Integer> sol = new ArrayList<>();
        while (sol.size() < k) {
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            sol.add(entry.getKey());
        }
        return sol;
    }
}