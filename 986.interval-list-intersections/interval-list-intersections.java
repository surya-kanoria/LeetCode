class Interval {
    public int start;
    public int end;
}

class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<Interval> list = new ArrayList();
        int up = 0, down = 0;
        while (up < A.length && down < B.length) {
            Interval interval = new Interval();
            if (A[up][0] > B[down][1]) {
                down++;
                continue;
            }
            if (B[down][0] > A[up][1]) {
                up++;
                continue;
            }
            if (A[up][0] < B[down][0]) {
                interval.start = B[down][0];
            } else {
                interval.start = A[up][0];
            }
            if (A[up][1] < B[down][1]) {
                interval.end = A[up][1];
                up++;
            } else {
                interval.end = B[down][1];
                down++;
            }
            list.add(interval);
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            Interval interval = list.get(i);
            res[i][0] = interval.start;
            res[i][1] = interval.end;
        }
        return res;
    }
}