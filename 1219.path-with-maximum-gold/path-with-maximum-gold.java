class Solution {
    public int getMaximumGold(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                visited[i][j] = false;
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visited[i][j] == false) {
                    int sum = dfs(grid, visited, i, j);
                    res = Math.max(res, sum);
                }
            }
        }
        return res;
    }

    public int dfs(int[][] grid, boolean[][] visited, int curRow, int curCol) {
        if (curRow < 0 || curCol < 0 || curRow >= grid.length || curCol >= grid[0].length) {
            return 0;
        }
        if (visited[curRow][curCol] == true || grid[curRow][curCol] == 0) {
            return 0;
        }
        visited[curRow][curCol] = true;
        int res = grid[curRow][curCol]
                + (Math.max(Math.max(dfs(grid, visited, curRow + 1, curCol), dfs(grid, visited, curRow - 1, curCol)),
                        Math.max(dfs(grid, visited, curRow, curCol + 1), dfs(grid, visited, curRow, curCol - 1))));
        visited[curRow][curCol] = false;
        return res;
    }
}