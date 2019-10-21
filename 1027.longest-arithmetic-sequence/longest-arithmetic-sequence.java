import java.util.HashMap;

class Solution {
    public int longestArithSeqLength(int[] A) {
        if (A == null || A.length <= 0) {
            return 0;
        }
        HashMap<Integer, Integer>[] map = new HashMap[A.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            map[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int diff = A[j] - A[i];
                if (map[j].containsKey(diff)) {
                    map[i].put(diff, map[j].get(diff) + 1);
                    max = Math.max(max, map[j].get(diff) + 1);
                } else {
                    map[i].put(diff, 2);
                    max = Math.max(max, 2);
                }
            }
        }
        return max;
    }
}