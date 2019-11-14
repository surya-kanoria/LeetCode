class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length <= 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == false && grid[i][j] == '1') {
                    count++;
                    visit(grid, visited, i, j);
                }
            }
        }
        return count;
    }

    private void visit(char[][] grid, boolean[][] visited, int row, int col) {
        visited[row][col] = true;
        if (grid[row][col] != '1') {
            return;
        }
        if (row < (grid.length - 1) && grid[row + 1][col] == '1' && visited[row + 1][col] == false) {
            visit(grid, visited, row + 1, col);
        }
        if (col < (grid[0].length - 1) && grid[row][col + 1] == '1' && visited[row][col + 1] == false) {
            visit(grid, visited, row, col + 1);
        }
        if (row > 0 && grid[row - 1][col] == '1' && visited[row - 1][col] == false) {
            visit(grid, visited, row - 1, col);
        }
        if (col > 0 && grid[row][col - 1] == '1' && visited[row][col - 1] == false) {
            visit(grid, visited, row, col - 1);
        }
    }
}