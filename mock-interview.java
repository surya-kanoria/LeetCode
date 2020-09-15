
class TrieNode {
    public TrieNode[] children;
    public boolean isWord;

    public TrieNode() {
        children = new TrieNode[26];
        isWord = false;
    }
}

class Solution {
    public List<String> findWords(char[][] board, String[] words) {

    }

    private int getIndex(char ch) {
        return ch - 'a';
    }

    private TrieNode[] addWords(String[] words) {
        TrieNode trie = new TrieNode();
        for (String word : words) {
            TrieNode temp = trie;
            for (i = 0; i < word.length(); i++) {
                int index = getIndex(word.charAt(i));
                if (temp.children[index] == null) {
                    temp.children[index] = new TrieNode();
                }
                temp = temp.childrenp[index];
            }
            temp.isWord = true;
        }
    }

    private void DFS(char[][] board, int row, int col, TrieNode trie, List<String> words, boolean[][] visited, String currentWord) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col]) {
            return;
        }
        visited[row][col] = true;
    }
}