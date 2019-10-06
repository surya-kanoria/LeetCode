/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    long maxSum = Long.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        long sum = getMaxPathSum(root);
        if (sum > maxSum) {
            maxSum = sum;
        }
        return (int) maxSum;
    }

    private long getMaxPathSum(TreeNode node) {
        if (node == null) {
            return Long.MIN_VALUE;
        }
        long leftSum = Long.MIN_VALUE, rightSum = Long.MIN_VALUE;
        if (node.left != null) {
            leftSum = getMaxPathSum(node.left);
        }
        if (node.right != null) {
            rightSum = getMaxPathSum(node.right);
        }
        long sum = node.val + Math.max(leftSum, 0) + Math.max(rightSum, 0);
        System.out.println(sum);
        if (sum > this.maxSum) {
            this.maxSum = sum;
        }
        return Math.max(node.val + Math.max(leftSum, 0), Math.max(node.val, node.val + Math.max(0, rightSum)));
    }
}