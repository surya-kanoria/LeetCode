class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() <= k) {
            return "0";
        }
        char[] s = num.toCharArray();
        for (int i = 0; i < k; i++) {
            int j;
            for (j = 0; j < (num.length() - 1 - i); j++) {
                int digit = Character.getNumericValue(s[j]);
                int nextDigit = Character.getNumericValue(s[(j + 1)]);
                if (digit > nextDigit) {
                    s[j] = ' ';
                    break;
                }
            }
            for (int l = j + 1; l < num.length(); l++) {
                s[l - 1] = s[l];
            }
        }
        StringBuilder sb = new StringBuilder(num.length() - k);
        boolean nonZeroFound = false;
        for (int i = 0; i < num.length() - k; i++) {
            if (Character.getNumericValue(s[i]) == 0 && nonZeroFound == false) {
                continue;
            } else {
                sb.append(s[i]);
                nonZeroFound = true;
            }
        }
        if (sb.toString().equals("")) {
            return "0";
        }
        return sb.toString();
    }
}