import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return null;
        }
        return getGeneratedParentheses(n, 0, 0);
    }

    private List<String> getGeneratedParentheses(int n, int currentOpen, int currentClose) {
        List<String> result = new ArrayList<>();
        if (currentOpen == n && currentClose == currentOpen) {
            result.add("");
            return result;
        }
        if (currentOpen < n) {
            List<String> openResults = getGeneratedParentheses(n, currentOpen + 1, currentClose);
            for (String openResult : openResults) {
                result.add("(" + openResult);
            }
        }
        if (currentClose < currentOpen) {
            List<String> closeResults = getGeneratedParentheses(n, currentOpen, currentClose + 1);
            for (String closeResult : closeResults) {
                result.add(")" + closeResult);
            }
        }
        return result;
    }
}