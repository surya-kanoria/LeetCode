class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                visited[i][j] = false;
            }
        }
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                if (getString(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean getString(char[][] board, String word, int currentIndex, int posI, int posJ, boolean[][] visited) {
        if (visited[posI][posJ] || word.charAt(currentIndex) != board[posI][posJ]) {
            return false;
        }
        if (currentIndex == (word.length() - 1)) {
            return true;
        }
        visited[posI][posJ] = true;
        if (posI < (board.length - 1)) {
            if (getString(board, word, currentIndex + 1, posI + 1, posJ, visited)) {
                visited[posI][posJ] = false;
                return true;
            }
        }
        if (posJ < (board[0].length - 1)) {
            if (getString(board, word, currentIndex + 1, posI, posJ + 1, visited)) {
                visited[posI][posJ] = false;
                return true;
            }
        }
        if (posI > 0) {
            if (getString(board, word, currentIndex + 1, posI - 1, posJ, visited)) {
                visited[posI][posJ] = false;
                return true;
            }
        }
        if (posJ > 0) {
            if (getString(board, word, currentIndex + 1, posI, posJ - 1, visited)) {
                visited[posI][posJ] = false;
                return true;
            }
        }
        visited[posI][posJ] = false;
        return false;
    }
}