/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public int rob(TreeNode root) {
        int[] result = getCount(root);
        return Math.max(result[0], result[1]);
    }

    private int[] getCount(TreeNode node) {
        int[] result = new int[2];
        if (node == null) {
            result[0] = 0;
            result[1] = 0;
        } else {
            int[] left = getCount(node.left);
            int[] right = getCount(node.right);
            result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
            result[1] = left[0] + right[0] + node.val;
        }
        return result;
    }
}