import java.util.ArrayList;

class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() <= 0) {
            return new ArrayList<>();
        }
        return getLetterCombinations(digits, 0);
    }

    private List<String> getLetterCombinations(String digits, int currentIndex) {
        List<String> results = new ArrayList<>();
        if (currentIndex == digits.length()) {
            results.add("");
        } else {
            String[] phone = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
            int currentDigit = Character.getNumericValue(digits.charAt(currentIndex));
            String text = phone[currentDigit];
            List<String> nextList = getLetterCombinations(digits, currentIndex + 1);
            for (int i = 0; i < text.length(); i++) {
                for (String next : nextList) {
                    results.add(text.charAt(i) + next);
                }
            }
        }
        return results;
    }
}