class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int start = i, end = i;
            while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                count++;
                start--;
                end++;
            }
            if ((i + 1) < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                start = i;
                end = i + 1;
                while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                    count++;
                    start--;
                    end++;
                }
            }
        }
        return count;
    }
}