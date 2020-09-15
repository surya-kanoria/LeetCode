class Solution {
    public int longestStrChain(String[] words) {
        int[] dp = new int[words.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        int max = Integer.MIN_VALUE;
        Arrays.sort(words, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        for (int i = 1; i < words.length; i++) {
            for (int j = 0; j < i; j++) {
                if (isPredecessor(words[j], words[i])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    System.out.println(words[j] + " --> " + words[i] + " " + max);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    private boolean isPredecessor(String word1, String word2) {
        if (Math.abs(word1.length() - word2.length()) != 1) {
            return false;
        }
        int i = 0, j = 0;
        boolean isSkipped = false;
        while (i < word1.length() && j < word2.length()) {
            if (word1.charAt(i) != word2.charAt(j)) {
                if (isSkipped) {
                    return false;
                } else {
                    isSkipped = true;
                    i = i + 1;
                }
            } else {
                i = i + 1;
                j = j + 1;
            }
        }
        return true;
    }
}