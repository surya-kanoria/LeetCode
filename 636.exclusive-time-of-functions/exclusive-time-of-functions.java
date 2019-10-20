class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] records = new int[n];
        for (int i = 0; i < n; i++) {
            records[i] = 0;
        }
        int previousTime = 0;
        Stack<Integer> stack = new Stack<>();
        for (String task : logs) {
            String[] breakdown = task.split(":");
            int taskId = Integer.parseInt(breakdown[0]);
            int timeStamp = Integer.parseInt(breakdown[2]);
            boolean isStart = "start".equalsIgnoreCase(breakdown[1]);
            if (isStart) {
                if (!stack.isEmpty()) {
                    int previousTask = stack.peek();
                    records[previousTask] += (timeStamp - previousTime);
                }
                stack.push(taskId);
                previousTime = timeStamp;
            } else {
                int currentTask = stack.pop();
                records[currentTask] += (timeStamp - previousTime + 1);
                previousTime = timeStamp + 1;
            }
        }
        return records;
    }
}