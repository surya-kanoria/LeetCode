class Solution {
    public int uniquePaths(int m, int n) {
        double value = 1;
        for (int i = 1; i <= n - 1; i++) {
            value = value * ((double) (m + i - 1) / (double) i);
        }
        return (int) Math.round(value);
    }
}