class Solution {
    public String decodeString(String s) {
        if (s == null || s.length() <= 0) {
            return s;
        }
        return decode(s);
    }

    private String decode(String s) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                int num = 0;
                while (Character.isDigit(s.charAt(i))) {
                    int digit = Character.getNumericValue(s.charAt(i));
                    num = num * 10 + digit;
                    i++;
                }
                int j = i + 1;
                StringBuilder sub = new StringBuilder();
                int open = 1;
                while (open > 0) {
                    sub.append(s.charAt(j));
                    j++;
                    if (s.charAt(j) == '[') {
                        open++;
                    } else if (s.charAt(j) == ']') {
                        open--;
                    }
                }
                String decodedSubString = decode(sub.toString());
                for (int k = 0; k < num; k++) {
                    sb.append(decodedSubString);
                }
                i = j + 1;
            } else if (Character.isLetter(s.charAt(i))) {
                sb.append(s.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }
}