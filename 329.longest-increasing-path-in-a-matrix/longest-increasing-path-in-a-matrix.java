class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) {
            return 0;
        }
        int max = 1;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                visited[i][j] = false;
                dp[i][j] = -1;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, getLongestIncreasingPath(matrix, i, j, dp, visited));
            }
        }
        return max;
    }

    private int getLongestIncreasingPath(int[][] matrix, int row, int col, int[][] dp, boolean[][] visited) {
        if (dp[row][col] != -1) {
            return dp[row][col];
        }
        if (visited[row][col]) {
            return 0;
        }
        int max = 1;
        visited[row][col] = true;
        if (row > 0 && matrix[row - 1][col] > matrix[row][col]) {
            max = Math.max(max, 1 + getLongestIncreasingPath(matrix, row - 1, col, dp, visited));
        }
        if (col > 0 && matrix[row][col - 1] > matrix[row][col]) {
            max = Math.max(max, 1 + getLongestIncreasingPath(matrix, row, col - 1, dp, visited));
        }
        if ((row < matrix.length - 1) && matrix[row + 1][col] > matrix[row][col]) {
            max = Math.max(max, 1 + getLongestIncreasingPath(matrix, row + 1, col, dp, visited));
        }
        if ((col < matrix[0].length - 1) && matrix[row][col + 1] > matrix[row][col]) {
            max = Math.max(max, 1 + getLongestIncreasingPath(matrix, row, col + 1, dp, visited));
        }
        visited[row][col] = false;
        dp[row][col] = max;
        return max;
    }
}