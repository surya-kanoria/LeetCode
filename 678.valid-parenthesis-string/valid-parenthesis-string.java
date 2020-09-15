class Solution {
    public boolean checkValidString(String s) {
        if (s == null || s.length() <= 0) {
            return true;
        }
        int count = 0;
        int starCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == '*') {
                starCount++;
            } else {
                count--;
            }
            if (count < 0) {
                if (starCount <= 0)
                    return false;
                else {
                    count++;
                    starCount--;
                }
            }
        }
        if (count > starCount) {
            return false;
        }
        return true;
    }
}