import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int length = 0, initialPosition = 0, maximumLength = 0;
        HashSet<Character> characterSet = new HashSet<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            if (!characterSet.contains(s.charAt(i))) {
                characterSet.add(s.charAt(i));
            } else {
                length = i - initialPosition;
                if (length > maximumLength) {
                    maximumLength = length;
                }
                do {
                    if (s.charAt(initialPosition) == s.charAt(i)) {
                        initialPosition++;
                        break;
                    } else {
                        characterSet.remove(s.charAt(initialPosition));
                        initialPosition++;
                    }
                } while (initialPosition <= i);
            }
        }
        length = s.length() - initialPosition;
        System.out.println(length + "," + maximumLength);
        if (length > maximumLength) {
            maximumLength = length;
        }
        return maximumLength;
    }
}