class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() <= 0) {
            return s;
        }
        String[] words = s.split(" ");
        Stack<String> reverseWords = new Stack<String>();
        for (int i = 0; i < words.length; i++) {
            if (" ".equalsIgnoreCase(words[i]) || "".equalsIgnoreCase(words[i])) {
                continue;
            } else {
                reverseWords.push(words[i]);
            }
        }
        StringBuilder sb = new StringBuilder(s.length());
        while (!reverseWords.empty()) {
            sb.append(reverseWords.pop());
            if (!reverseWords.empty()) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}