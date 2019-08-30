import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return null;
        }
        List<String> list = getParenthesis(n);
        List<String> newList = new ArrayList<>();
        for (String combination : list) {
            if (combination.charAt(0) == '1') {
                combination = combination.substring(1, combination.length());
            }
            newList.add(combination);
        }
        return newList;
    }

    private List<String> getParenthesis(int n) {
        if (n == 1) {
            return Arrays.asList("()");
        } else if (n == 2) {
            return Arrays.asList("(())", "1()()");
        } else {
            List<String> oldList = getParenthesis(n - 1);
            ArrayList<String> newList = new ArrayList();
            for (String combination : oldList) {
                if (combination.charAt(0) != '1') {
                    String firstCombo = "(" + combination + ")";
                    String secondCombo = "()" + combination;
                    String thirdCombo = combination + "()";
                    newList.add(firstCombo);
                    newList.add(secondCombo);
                    newList.add(thirdCombo);
                } else {
                    String firstCombo = "(" + combination.substring(1, combination.length()) + ")";
                    String secondCombo = combination + "()";
                    newList.add(firstCombo);
                    newList.add(secondCombo);
                }
            }
            return newList;
        }
    }
}