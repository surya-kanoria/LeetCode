import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        if (points == null || points.length <= 0) {
            return new int[0][2];
        }
        PriorityQueue<Integer[]> priorityQueue = new PriorityQueue<>(new Comparator<Integer[]>() {
            public int compare(Integer[] i1, Integer[] i2) {
                double dist1 = Math.pow(i1[0].intValue(), 2) + Math.pow(i1[1].intValue(), 2);
                double dist2 = Math.pow(i2[0].intValue(), 2) + Math.pow(i2[1].intValue(), 2);
                return (int) (dist2 - dist1);
            }
        });
        for (int i = 0; i < points.length; i++) {
            Integer[] point = new Integer[2];
            point[0] = points[i][0];
            point[1] = points[i][1];
            priorityQueue.offer(point);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        int[][] res = new int[k][2];
        for (int i = 0; !priorityQueue.isEmpty(); i++) {
            Integer[] point = priorityQueue.poll();
            res[i][0] = point[0];
            res[i][1] = point[1];
        }
        return res;
    }
}