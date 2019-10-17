class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() <= 0) {
            return null;
        }
        String[] split = path.split("/");
        HashSet<String> set = new HashSet<>();
        Stack<String> stack = new Stack();
        for (int i = 0; i < split.length; i++) {
            if (split[i].equalsIgnoreCase(".") || split[i].isEmpty()) {
                continue;
            } else if (split[i].equalsIgnoreCase("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(split[i]);
            }
        }
        Stack<String> newStack = new Stack();
        while (!stack.isEmpty()) {
            String temp = stack.pop();
            newStack.push(temp);
        }
        StringBuilder sb = new StringBuilder();
        do {
            sb.append("/");
            if (!newStack.isEmpty()) {
                String temp = newStack.pop();
                sb.append(temp);
            }
        } while (!newStack.isEmpty());
        return sb.toString();
    }
}