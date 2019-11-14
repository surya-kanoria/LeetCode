/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    int min = Integer.MAX_VALUE;
    int nodeValue = -1;

    public int findClosestLeaf(TreeNode root, int k) {
        parentDistance(root, k);
        return nodeValue;
    }

    private int parentDistance(TreeNode node, int k) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }
        if (node.val == k) {
            childDistance(node, 0);
            return 0;
        }
        int left = parentDistance(node.left, k);
        if (left != Integer.MAX_VALUE) {
            childDistance(node.right, left + 2);
        }
        int right = parentDistance(node.right, k);
        if (right != Integer.MAX_VALUE) {
            childDistance(node.left, right + 2);
        }
        return Math.min(left, right);
    }

    private void childDistance(TreeNode node, int currentLevel) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            if (currentLevel < min) {
                min = currentLevel;
                nodeValue = node.val;
            }
        }
        childDistance(node.left, currentLevel + 1);
        childDistance(node.right, currentLevel + 1);
    }
}