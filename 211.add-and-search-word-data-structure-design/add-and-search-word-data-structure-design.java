class TrieNode {
    public TrieNode[] children;
    public boolean isEnd;

    public TrieNode() {
        children = new TrieNode[26];
        isEnd = false;
    }
}

class WordDictionary {
    TrieNode trie;

    /** Initialize your data structure here. */
    public WordDictionary() {
        trie = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode temp = trie;
        for (int i = 0; i < word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            if (temp.children[pos] == null) {
                temp.children[pos] = new TrieNode();
            }
            temp = temp.children[pos];
        }
        temp.isEnd = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot
     * character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return getSearchResult(word, 0, trie);
    }

    private boolean getSearchResult(String word, int currentPos, TrieNode current) {
        if (currentPos == word.length()) {
            return current.isEnd;
        }
        boolean result = false;
        if (word.charAt(currentPos) == '.') {
            for (int i = 0; i < current.children.length; i++) {
                if (current.children[i] != null) {
                    result = result || getSearchResult(word, currentPos + 1, current.children[i]);
                }
            }
        } else {
            int pos = word.charAt(currentPos) - 'a';
            if (current.children[pos] != null) {
                result = getSearchResult(word, currentPos + 1, current.children[pos]);
            }
        }
        return result;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary(); obj.addWord(word); boolean param_2
 * = obj.search(word);
 */