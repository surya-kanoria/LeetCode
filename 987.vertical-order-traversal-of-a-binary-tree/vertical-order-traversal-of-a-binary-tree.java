import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    private int minVerAxis = Integer.MAX_VALUE;
    private int maxVerAxis = Integer.MIN_VALUE;
    private int maxHorAxis = Integer.MIN_VALUE;
    private int minHorAxis = Integer.MAX_VALUE;

    private HashMap<Integer, HashMap<Integer, PriorityQueue<Integer>>> traversal = new HashMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        getVerticalTransfer(root, 0, 0);
        // System.out.println("Traversal done!!!" + minVerAxis + " , " + maxVerAxis);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = minVerAxis; i <= maxVerAxis; i++) {
            HashMap<Integer, PriorityQueue<Integer>> currentLevel = traversal.get(i);
            List<Integer> currentLevelResult = new ArrayList<>();
            for (int j = minHorAxis; j <= maxHorAxis; j++) {
                if (!currentLevel.containsKey(j)) {
                    continue;
                }
                PriorityQueue<Integer> priorityQueue = currentLevel.get(j);
                while (!priorityQueue.isEmpty()) {
                    currentLevelResult.add(priorityQueue.poll());
                }
            }
            res.add(currentLevelResult);
        }
        return res;

    }

    private void getVerticalTransfer(TreeNode node, int verAxis, int horAxis) {
        if (node == null) {
            return;
        }
        // System.out.println(verAxis + " , " + horAxis + " --> " + node.val);
        HashMap<Integer, PriorityQueue<Integer>> currentLevel = traversal.getOrDefault(verAxis, new HashMap<>());
        PriorityQueue<Integer> priorityQueue = currentLevel.getOrDefault(horAxis, new PriorityQueue<>());
        priorityQueue.add(node.val);
        currentLevel.put(horAxis, priorityQueue);
        traversal.put(verAxis, currentLevel);
        minVerAxis = Math.min(minVerAxis, verAxis);
        maxVerAxis = Math.max(maxVerAxis, verAxis);
        minHorAxis = Math.min(minHorAxis, horAxis);
        maxHorAxis = Math.max(maxHorAxis, horAxis);
        getVerticalTransfer(node.left, verAxis - 1, horAxis + 1);
        getVerticalTransfer(node.right, verAxis + 1, horAxis + 1);
    }
}