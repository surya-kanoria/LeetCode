class Solution {
    public String alphabetBoardPath(String target) {
        String[] board = { "abcde", "fghij", "klmno", "pqrst", "uvwxy", "z" };
        HashMap<Character, Integer> row = new HashMap<>();
        HashMap<Character, Integer> col = new HashMap<>();
        for (int rowCursor = 0; rowCursor < board.length; rowCursor++) {
            for (int colCursor = 0; colCursor < board[rowCursor].length(); colCursor++) {
                row.put(board[rowCursor].charAt(colCursor), rowCursor);
                col.put(board[rowCursor].charAt(colCursor), colCursor);
            }
        }
        int currentRow = 0, currentCol = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            char targetChar = target.charAt(i);
            int targetRow = row.get(targetChar);
            int targetCol = col.get(targetChar);
            if (targetChar == 'z') {
                while (currentCol < targetCol) {
                    sb.append("R");
                    currentCol++;
                }
                while (currentCol > targetCol) {
                    sb.append("L");
                    currentCol--;
                }
                while (currentRow < targetRow) {
                    sb.append("D");
                    currentRow++;
                }
                while (currentRow > targetRow) {
                    sb.append("U");
                    currentRow--;
                }
            } else {
                while (currentRow < targetRow) {
                    sb.append("D");
                    currentRow++;
                }
                while (currentRow > targetRow) {
                    sb.append("U");
                    currentRow--;
                }
                while (currentCol < targetCol) {
                    sb.append("R");
                    currentCol++;
                }
                while (currentCol > targetCol) {
                    sb.append("L");
                    currentCol--;
                }
            }

            sb.append("!");
        }
        return sb.toString();
    }
}