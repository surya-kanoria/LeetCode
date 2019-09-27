class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) {
            return new ArrayList();
        }

        int row1 = 0, row2 = matrix.length - 1;
        int col1 = 0, col2 = matrix[0].length - 1;
        List list = new ArrayList();
        while (row1 <= row2 && col1 <= col2) {
            for (int i = col1; i <= col2; i++) {
                list.add(matrix[row1][i]);
            }
            for (int i = row1 + 1; i <= row2; i++) {
                list.add(matrix[col2][i]);
            }
            if (row1 < row2 && col1 < col2) {
                for (int i = col2 - 1; i > col1; i--) {
                    list.add(matrix[row2][i]);
                }
                for (int i = row2; i > row1; i--) {
                    list.add(matrix[col1][i]);
                }
            }
            row1 = row1 + 1;
            row2 = row2 - 1;
            col1 = col1 + 1;
            col2 = col2 - 1;
        }
        return list;
    }
}