class Solution {
    public boolean isMatch(String s, String p) {
        if (p == null || p.length() <= 0) {
            return true;
        }
        if (s == null || s.length() <= 0) {
            return p.charAt(0) == '*';
        }
        int[][] dp = new int[s.length()][p.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                dp[i][j] = -1;
            }
        }
        return checkForMatch(s, p, 0, 0, dp);
    }

    private boolean checkForMatch(String s, String p, int sIndex, int pIndex, int[][] dp) {
        if (sIndex >= s.length()) {
            boolean allStar = true;
            for (int i = pIndex; i < p.length(); i++) {
                if (p.charAt(i) != '*' && (i < p.length() - 1 && p.charAt(i + 1) != '*')) {
                    allStar = false;
                    break;
                }
            }
            return allStar;
        }
        if (pIndex >= p.length()) {
            return false;
        }
        if (dp[sIndex][pIndex] != -1) {
            return dp[sIndex][pIndex] == 1 ? true : false;
        }
        boolean result = false;
        if (p.charAt(pIndex) == '.' && sIndex != s.length()) {
            result = result || checkForMatch(s, p, sIndex + 1, pIndex + 1, dp);
        } else if (p.charAt(pIndex) == '*') {
            result = result || checkForMatch(s, p, sIndex, pIndex + 1, dp);
            if (pIndex > 0 && (p.charAt(pIndex - 1) == '.' || p.charAt(pIndex - 1) == s.charAt(sIndex))) {
                result = result || checkForMatch(s, p, sIndex + 1, pIndex + 1, dp);
                result = result || checkForMatch(s, p, sIndex + 1, pIndex, dp);
            }
        } else {
            if (p.charAt(pIndex) == s.charAt(sIndex)) {
                result = result || checkForMatch(s, p, sIndex + 1, pIndex + 1, dp);
            } else if ((pIndex < p.length() - 1) && p.charAt(pIndex + 1) == '*') {
                result = result || checkForMatch(s, p, sIndex, pIndex + 2, dp);
            }
        }
        if (result == true) {
            dp[sIndex][pIndex] = 1;
        } else {
            dp[sIndex][pIndex] = 0;
        }
        return result;
    }

}