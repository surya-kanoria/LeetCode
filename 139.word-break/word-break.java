class Solution {
    class TrieNode {
        boolean wordEnd = false;
        TrieNode[] next = new TrieNode[128];
    }

    private void addWord(TrieNode t, String w) {
        for (int i = 0; i < w.length(); i++) {
            int j = (int) w.charAt(i);
            if (t.next[j] == null)
                t.next[j] = new TrieNode();
            t = t.next[j];
        }
        t.wordEnd = true;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        TrieNode t = new TrieNode(), cur;
        for (String i : wordDict) {
            addWord(t, i);
        }
        char[] str = s.toCharArray();
        int len = str.length;
        boolean[] f = new boolean[len + 1];
        f[len] = true;

        for (int i = len - 1; i >= 0; i--) {
            cur = t;
            for (int j = i; cur != null && j < len; j++) {
                cur = cur.next[(int) str[j]];
                if (cur != null && cur.wordEnd && f[j + 1]) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[0];
    }
}