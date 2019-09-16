/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public void flatten(TreeNode root) {
        flattenTree(root);
    }

    private TreeNode flattenTree(TreeNode node) {
        if (node == null || (node.right == null && node.left == null)) {
            return node;
        }
        TreeNode left = null, right = null;
        if (node.left != null) {
            left = flattenTree(node.left);
        }
        if (node.right != null) {
            right = flattenTree(node.right);
        }
        if (node.left == null) {
            return right;
        }
        if (node.right == null) {
            node.right = node.left;
            node.left = null;
            return left;
        }
        left.right = node.right;
        node.right = node.left;
        node.left = null;
        return right;
    }
}