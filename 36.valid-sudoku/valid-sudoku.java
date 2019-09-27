class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<HashSet<Character>> rows = new ArrayList<HashSet<Character>>(9);
        List<HashSet<Character>> cols = new ArrayList<HashSet<Character>>(9);
        List<HashSet<Character>> blocks = new ArrayList<HashSet<Character>>(9);
        for (int i = 0; i < 9; i++) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
            blocks.add(new HashSet<>());
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                } else {
                    char number = board[i][j];
                    if (rows.get(i).contains(number)) {
                        return false;
                    } else {
                        rows.get(i).add(number);
                    }
                    if (cols.get(j).contains(number)) {
                        return false;
                    } else {
                        cols.get(j).add(number);
                    }
                    int block = ((i / 3) * 3) + (j / 3);
                    if (blocks.get(block).contains(number)) {
                        return false;
                    } else {
                        blocks.get(block).add(number);
                    }
                }
            }
        }
        return true;
    }
}