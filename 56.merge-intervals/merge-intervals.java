class Solution {
    public int[][] merge(int[][] intervals) {

        if (intervals.length <= 1) {
            return intervals;
        }

        List<int[]> merged = new ArrayList<>();
        Arrays.sort(intervals);

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] <= end) {
                end = Math.max(intervals[i][1], end);
            } else {
                int[] list = new int[] { start, end };
                merged.add(list);
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        int[] list = new int[] { start, end };
        merged.add(list);

        return merged.toArray(new int[merged.size()][2]);
    }
}