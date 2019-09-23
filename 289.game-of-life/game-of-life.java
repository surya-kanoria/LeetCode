class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length <= 0 || board[0].length <= 0) {
            return;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int count = 0;
                if (i > 0 && j > 0 && Math.abs(board[(i - 1)][(j - 1)]) == 1) {
                    count++;
                }
                if (i > 0 && Math.abs(board[(i - 1)][j]) == 1) {
                    count++;
                }
                if (i > 0 && (j + 1) < board[0].length && Math.abs(board[i - 1][j + 1]) == 1) {
                    count++;
                }
                if (j > 0 && Math.abs(board[i][j - 1]) == 1) {
                    count++;
                }
                if (j > 0 && (i + 1) < board.length && Math.abs(board[i + 1][j - 1]) == 1) {
                    count++;
                }
                if ((i + 1) < board.length && Math.abs(board[i + 1][j]) == 1) {
                    count++;
                }
                if ((i + 1) < board.length && (j + 1) < board[0].length && Math.abs(board[i + 1][j + 1]) == 1) {
                    count++;
                }
                if ((j + 1) < board[0].length && Math.abs(board[i][j + 1]) == 1) {
                    count++;
                }
                if (board[i][j] == 1 && (count < 2 || count > 3)) {
                    board[i][j] = -1; // goes from 1 to 0
                }
                if (board[i][j] == 0 && count == 3) {
                    board[i][j] = 2; // goes from 0 to 1
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 0;
                } else if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
            }
        }
    }
}