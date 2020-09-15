class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length <= 0) {
            int[][] newIntervals = new int[1][2];
            newIntervals[0] = newInterval;
            return newIntervals;
        }
        int[][] newIntervals = new int[intervals.length + 1][2];
        int[] insertedInterval = intervals[1];
        for (int i = 1; i < intervals.length; i++) {

        }
    }
}