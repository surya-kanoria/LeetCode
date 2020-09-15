import java.util.HashMap;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public int maxLevelSum(TreeNode root) {
        int maxLevel = 1, maxSum = Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = getMaxLevelSum(root, new HashMap<>(), 1);
        for (int i = 1; i <= map.size(); i++) {
            int levelSum = map.get(i);
            if (levelSum > maxSum) {
                maxSum = levelSum;
                maxLevel = i;
            }
        }
        return maxLevel;
    }

    private HashMap<Integer, Integer> getMaxLevelSum(TreeNode node, HashMap<Integer, Integer> levelMap, int currLevel) {
        if (node == null) {
            return levelMap;
        }
        int currentSum = levelMap.getOrDefault(currLevel, 0);
        currentSum = currentSum + node.val;
        levelMap.put(currLevel, currentSum);
        levelMap = getMaxLevelSum(node.left, levelMap, currLevel + 1);
        return getMaxLevelSum(node.right, levelMap, currLevel + 1);
    }
}