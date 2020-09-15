import java.util.HashMap;

class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int max = 0;
        int start = 0;
        for (List<Integer> list : wall) {
            start = 0;
            for (int brick : list) {
                start = start + brick;
                count.put(start, count.getOrDefault(start, 0) + 1);
            }
        }
        for (int col : count.keySet()) {
            if (col == start) {
                continue;
            }
            max = Math.max(max, count.get(col));
        }
        return wall.size() - max;
    }
}