class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack();
        int[] solution = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            solution[i] = 0;
        }
        for (int i = 0; i < T.length; i++) {
            if (stack.empty() || T[stack.peek()] >= T[i]) {
                stack.push(i);
            } else {
                while (!stack.empty() && T[stack.peek()] < T[i]) {
                    int pos = stack.pop();
                    solution[pos] = i - pos;
                }
                stack.push(i);
            }
        }
        return solution;
    }
}