import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Solution {
    private Trie trie;

    public class Trie {
        public int endIndex;
        public Trie[] children;

        public Trie() {
            this.endIndex = -1;
            this.children = new Trie[26];
        }
    }

    private void addWord(Trie trie, String word, int index) {
        Trie node = trie;
        for (int i = 0; i < word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            if (node.children[pos] == null) {
                node.children[pos] = new Trie();
            }
            node = node.children[pos];
        }
        // System.out.println("Trie:" + word);
        node.endIndex = index;
    }

    private void processWord(Trie trie, String word, int wordIndex, List<String> ret, int startPos) {
        Trie node = trie;
        for (int i = startPos; i < word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            if (node.children[pos] == null) {
                return;
            } else {
                node = node.children[pos];
                if (node.endIndex >= 0 && node.endIndex != wordIndex) {
                    // System.out.println(word + " " + node.endIndex + " " + i);
                    processWord(this.trie, word, wordIndex, ret, i + 1);
                }
            }
        }
        if (node.endIndex != wordIndex && node.endIndex >= 0) {
            // System.out.println("Adding word: " + word + " " + node.endIndex + " " +
            // wordIndex);
            ret.add(word);
        }
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        trie = new Trie();
        List<String> ret = new LinkedList();
        for (int i = 0; i < words.length; i++) {
            addWord(trie, words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            processWord(trie, words[i], i, ret, 0);
        }
        // Iterator<String> itr = ret.iterator();
        // List<String> ans = new ArrayList<>();
        // while (itr.hasNext()) {
        // ans.add(itr.next());
        // }
        return ret;
    }
}