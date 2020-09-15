import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public boolean canReorderDoubled(int[] A) {
        Integer[] sorted = new Integer[A.length];
        for (int i = 0; i < A.length; i++) {
            sorted[i] = A[i];
        }
        Arrays.sort(sorted, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return Math.abs(a.intValue()) - Math.abs(b.intValue());
            }
        });
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            count.put(A[i], count.getOrDefault(A[i], 0) + 1);
        }
        for (int i = 0; i < A.length; i++) {
            if (count.getOrDefault(sorted[i], 0) == 0) {
                continue;
            } else {
                if (count.getOrDefault(2 * sorted[i], 0) == 0) {
                    return false;
                } else {
                    count.put(sorted[i], count.get(sorted[i]) - 1);
                    count.put(2 * sorted[i], count.get(2 * sorted[i]) - 1);
                }
            }
        }
        return true;
    }
}