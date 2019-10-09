import java.util.HashMap;

class Solution {
    public int maxPoints(int[][] points) {
        if (points == null || points.length <= 0) {
            return 0;
        }
        int maxCount = 0;
        for (int i = 0; i < points.length; i++) {
            HashMap<Double, Integer> map = new HashMap<>();
            int[] refPoint = points[i];
            int same = 0;
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    if (points[j][0] == refPoint[0] && points[j][1] == refPoint[1]) {
                        same = same + 1;
                        maxCount = Math.max(maxCount, same);
                        continue;
                    } else {
                        Double slope = Double.MAX_VALUE;
                        if (points[j][0] != refPoint[0]) {
                            slope = (((double) points[j][1] - refPoint[1]) / ((double) points[j][0] - refPoint[0]));
                        }
                        System.out.println(i + "," + j + "," + slope);
                        int currentSlopeCount = map.getOrDefault(slope, 0);
                        map.put(slope, currentSlopeCount + 1);
                        maxCount = Math.max(maxCount, currentSlopeCount + 1 + same);
                    }
                }
            }
        }
        return maxCount + 1;
    }
}