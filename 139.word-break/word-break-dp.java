class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length()];
        Set<String> wordSet = new HashSet<>(wordDict.size());
        for (String word : wordDict) {
            wordSet.add(word);
        }
        return getWordBreak(s, 0, wordSet, dp);
    }

    private boolean getWordBreak(String s, int pos, Set<String> wordDict, int[] dp) {
        if (pos >= s.length()) {
            return true;
        } else if (dp[pos] > 0) {
            return dp[pos] == 2;
        }
        for (int i = pos; i < s.length(); i++) {
            if (wordDict.contains(s.substring(pos, i + 1))) {
                if (getWordBreak(s, i + 1, wordDict, dp)) {
                    dp[pos] = 2;
                    return true;
                }
            }
        }
        dp[pos] = 1;
        return false;
    }
}