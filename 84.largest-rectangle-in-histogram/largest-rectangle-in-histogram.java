class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length <= 0) {
            return 0;
        }
        int maxArea = Integer.MIN_VALUE;
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < heights.length; i++) {
            if (stack.empty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i);
            } else {
                while (!stack.empty() && heights[stack.peek()] > heights[i]) {
                    int n = stack.pop();
                    right[n] = i - 1;
                }
                stack.push(i);
            }
        }
        while (!stack.empty()) {
            int n = stack.pop();
            right[n] = heights.length - 1;
        }
        for (int i = heights.length - 1; i >= 0; i--) {
            if (stack.empty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i);
            } else {
                while (!stack.empty() && heights[stack.peek()] > heights[i]) {
                    int n = stack.pop();
                    left[n] = i + 1;
                }
                stack.push(i);
            }
        }
        while (!stack.empty()) {
            int n = stack.pop();
            left[n] = 0;
        }
        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, (right[i] - left[i] + 1) * heights[i]);
        }
        return maxArea;
    }
}
