import java.util.ArrayList;

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        if (words == null || words.length <= 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isPalindrome(words[i], words[j])) {
                    List<Integer> list = new ArrayList(2);
                    list.add(i);
                    list.add(j);
                    result.add(list);
                }
                if (isPalindrome(words[j], words[i])) {
                    List<Integer> list = new ArrayList(2);
                    list.add(j);
                    list.add(i);
                    result.add(list);
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(String word1, String word2) {
        int start = 0;
        int end = word2.length() - 1;
        while (start < word1.length() && end >= 0) {
            if (word1.charAt(start) != word2.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        if (end >= 0) {
            start = 0;
            while (start <= end) {
                if (word2.charAt(start) != word2.charAt(end)) {
                    return false;
                }
                end--;
                start++;
            }
        } else if (start < word1.length()) {
            end = word1.length() - 1;
            while (start <= end) {
                if (word1.charAt(start) != word1.charAt(end)) {
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }
}