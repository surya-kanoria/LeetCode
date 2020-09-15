import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

class Solution {
    public int[] avoidFlood(int[] rains) {
        TreeSet<Integer> freeDays = new TreeSet<>();
        HashMap<Integer, Integer> filledLake = new HashMap<>();
        int[] sol = new int[rains.length];
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] > 0) {
                sol[i] = -1;
                if (filledLake.containsKey(rains[i])) {
                    // if (freeDays.isEmpty() || (filledLake.get(rains[i]) > freeDays.peek())) {
                    // return new int[0];
                    // } else {
                    // int freeDay = freeDays.poll();
                    // sol[freeDay] = rains[i];
                    // }
                    Integer freeDay = freeDays.ceiling(filledLake.get(rains[i]));
                    if (freeDay == null) {
                        return new int[0];
                    } else {
                        sol[freeDay] = rains[i];
                        freeDays.remove(freeDay);
                    }
                }
                filledLake.put(rains[i], i);
            } else {
                freeDays.add(i);
                sol[i] = 1;
            }
        }
        return sol;
    }
}