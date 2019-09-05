class Solution {
    public int minPathSum(int[][] grid) {
        int[][] solGrid = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                solGrid[i][j] = -1;
            }
        }
        return getMinPathSum(grid, 0, 0, solGrid);
    }

    private int getMinPathSum(int[][] grid, int startRow, int startCol, int[][] solGrid) {
        if (solGrid[startRow][startCol] != -1) {
            return solGrid[startRow][startCol];
        }
        int row = Integer.MAX_VALUE, col = Integer.MAX_VALUE;
        if ((startRow == (grid.length - 1)) && (startCol == (grid[0].length - 1))) {
            return grid[(grid.length - 1)][(grid[0].length - 1)];
        }
        if (startRow < grid.length - 1) {
            row = getMinPathSum(grid, startRow + 1, startCol, solGrid);
        }
        if (startCol < (grid[0].length - 1)) {
            col = getMinPathSum(grid, startRow, startCol + 1, solGrid);
        }
        solGrid[startRow][startCol] = Math.min(row, col) + grid[startRow][startCol];
        return solGrid[startRow][startCol];
    }
}