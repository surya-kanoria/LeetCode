import java.util.Random;
import java.util.TreeMap;
import java.util.TreeSet;

class Solution {
    private TreeMap<Long, Integer> treeMap;
    private long count;

    public Solution(int[] w) {
        count = 0;
        treeMap = new TreeMap<>();
        for (int i = 0; i < w.length; i++) {
            count = count + w[i];
            treeMap.put(count, i);
        }
    }

    public int pickIndex() {
        long randomNum = (long) Math.ceil(Math.random() * count);
        return treeMap.ceilingEntry(randomNum).getValue();
    }
}

/**
 * Your Solution object will be instantiated and called as such: Solution obj =
 * new Solution(w); int param_1 = obj.pickIndex();
 */