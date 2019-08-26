class Solution {
    public String longestPalindrome(String s) {
        int j, i, length = 1;
        int maxLength = 0;
        int startPos = 0, endPos = 0;
        if (s.length() <= 0) {
            return "";
        }
        for (i = 0; i < s.length(); i++) {
            for (j = 0; ((i - j) >= 0 && (i + j) < s.length()); j++) {
                if (s.charAt(i - j) != s.charAt(i + j)) {
                    break;
                }
            }
            j--;
            length = (j * 2) + 1;
            if (length > maxLength) {
                maxLength = length;
                startPos = i - j;
                endPos = i + j;
            }
            if (i + 1 != s.length()) {
                if (s.charAt(i) == s.charAt((i + 1))) {
                    for (j = 0; ((i - j) >= 0 && (i + j + 1) < s.length()); j++) {
                        if (s.charAt(i - j) != s.charAt(i + j + 1)) {
                            break;
                        }
                    }
                    j--;
                    length = (j * 2) + 2;
                    if (length > maxLength) {
                        maxLength = length;
                        startPos = i - j;
                        endPos = i + j + 1;
                    }
                }
            }
        }
        System.out.println(startPos + "," + endPos);
        return s.substring(startPos, endPos + 1);
    }
}