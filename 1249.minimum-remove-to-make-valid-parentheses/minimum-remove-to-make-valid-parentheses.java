import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> open = new Stack<Integer>();
        Set<Integer> closed = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open.push(i);
            } else if (s.charAt(i) == ')') {
                if (open.empty()) {
                    closed.add(i);
                } else {
                    open.pop();
                }
            }
        }
        Set<Integer> remainingOpen = new HashSet();
        while (!open.empty()) {
            remainingOpen.add(open.pop());
        }
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++) {
            if (remainingOpen.contains(i) || closed.contains(i)) {
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}