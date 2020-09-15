import java.util.HashSet;
import java.util.Stack;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        HashSet<Integer> passed = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < popped.length; i++) {
            if (passed.contains(popped[i])) {
                if (stack.peek() == popped[i]) {
                    stack.pop();
                    continue;
                } else {
                    return false;
                }
            } else {
                int flag = 0;
                while (j < pushed.length) {
                    if (pushed[j] == popped[i]) {
                        j = j + 1;
                        flag = 1;
                        break;
                    } else {
                        passed.add(pushed[j]);
                        stack.push(pushed[j]);
                        j = j + 1;
                    }
                }
                if (flag == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}