import java.util.Comparator;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length <= 0) {
            if (newInterval == null) {
                return null;
            } else {
                int[][] result = new int[1][2];
                result[0][0] = newInterval[0];
                result[0][1] = newInterval[1];
                return result;
            }
        }
        int[][] newIntervals = new int[intervals.length + 1][2];
        int i;
        int j = 0;
        for (i = 0; i < intervals.length; i++) {
            if (intervals[i][1] < newInterval[0]) {
                newIntervals[i][0] = intervals[i][0];
                newIntervals[i][1] = intervals[i][1];
            } else {
                break;
            }
            j++;
        }
        if (i >= intervals.length || newInterval[0] < intervals[i][0]) {
            newIntervals[i][0] = newInterval[0];
        } else {
            newIntervals[i][0] = intervals[i][0];
        }
        while (i < intervals.length) {
            if (intervals[i][0] > newInterval[1]) {
                break;
            }
            i++;
        }
        if (intervals[i - 1][1] > newInterval[1]) {
            newIntervals[j][1] = intervals[i - 1][1];
        } else {
            newIntervals[j][1] = newInterval[1];
        }
        j++;
        while (i < intervals.length) {
            newIntervals[j][0] = intervals[i][0];
            newIntervals[j][1] = intervals[i][1];
            i++;
            j++;
        }
        int[][] result = new int[j][2];
        for (i = 0; i < j; i++) {
            result[i][0] = newIntervals[i][0];
            result[i][1] = newIntervals[i][1];
        }
        return result;
    }
}