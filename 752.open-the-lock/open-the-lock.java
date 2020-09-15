import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public class Node {
        public int change;
        public String combination;

        public Node(int change, String combination) {
            this.change = change;
            this.combination = combination;
        }
    }

    public int openLock(String[] deadends, String target) {
        HashSet<String> deadEndSet = new HashSet<>();
        for (int i = 0; i < deadends.length; i++) {
            deadEndSet.add(deadends[i]);
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, "0000"));
        HashSet<String> completed = new HashSet<>();
        completed.add("0000");
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (target.compareTo(node.combination) == 0) {
                return node.change;
            }
            for (int i = 0; i < node.combination.length(); i++) {
                int currentNum = node.combination.charAt(i) - '0';
                String newCombination = node.combination.substring(0, i) + String.valueOf(currentNum + 1)
                        + node.combination.substring(i + 1);
                if (!completed.contains(newCombination) && !deadEndSet.contains(newCombination)) {
                    completed.add(newCombination);
                    queue.offer(new Node(node.change + 1, newCombination));
                }
                newCombination = node.combination.substring(0, i) + String.valueOf(currentNum - 1)
                        + node.combination.substring(i + 1);
                if (!completed.contains(newCombination) && !deadEndSet.contains(newCombination)) {
                    completed.add(newCombination);
                    queue.offer(new Node(node.change + 1, newCombination));
                }
            }
        }
        return -1;
    }
}