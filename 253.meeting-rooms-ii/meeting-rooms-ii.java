import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length <= 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] i1, int[] i2) {
                return i1[0] - i2[0];
            }
        });
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(intervals.length, new Comparator<int[]>() {
            @Override
            public int compare(int[] i1, int[] i2) {
                return i1[1] - i2[1];
            }
        });
        priorityQueue.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if ((priorityQueue.peek())[1] <= intervals[i][0]) {
                priorityQueue.poll();
            }
            priorityQueue.add(intervals[i]);
        }
        return priorityQueue.size();
    }
}