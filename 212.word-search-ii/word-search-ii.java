import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class Solution {

    private Trie trie = new Trie();

    public class Trie {
        public Trie[] children;
        public boolean isEnd;

        public Trie() {
            this.children = new Trie[26];
        }
    }

    private void addWord(String word) {
        Trie node = trie;
        for (int i = 0; i < word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            if (node.children[pos] == null) {
                node.children[pos] = new Trie();
            }
            node = node.children[pos];
        }
        node.isEnd = true;
    }

    public List<String> findWords(char[][] board, String[] words) {
        for (int i = 0; i < words.length; i++) {
            addWord(words[i]);
        }
        Set<String> ret = new HashSet();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                getWord(board, i, j, this.trie, "", ret, visited);
            }
        }
        List<String> ans = new ArrayList<>();
        Iterator<String> itr = ret.iterator();
        while (itr.hasNext()) {
            ans.add(itr.next());
        }
        return ans;
    }

    private void getWord(char[][] board, int row, int col, Trie node, String currentWord, Set<String> words,
            boolean[][] visited) {
        int pos = board[row][col] - 'a';
        if (node.children[pos] == null || visited[row][col] == true) {
            return;
        } else if (node.children[pos].isEnd == true) {
            words.add(currentWord + board[row][col]);
        }
        visited[row][col] = true;
        if (row > 0) {
            getWord(board, row - 1, col, node.children[pos], currentWord + board[row][col], words, visited);
        }
        if (row < board.length - 1) {
            getWord(board, row + 1, col, node.children[pos], currentWord + board[row][col], words, visited);
        }
        if (col > 0) {
            getWord(board, row, col - 1, node.children[pos], currentWord + board[row][col], words, visited);
        }
        if (col < board[0].length - 1) {
            getWord(board, row, col + 1, node.children[pos], currentWord + board[row][col], words, visited);
        }
        visited[row][col] = false;
    }
}