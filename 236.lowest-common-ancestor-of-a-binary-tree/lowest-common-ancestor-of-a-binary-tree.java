/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        return getLowestCommonAncestor(root, p, q);
    }

    public TreeNode getLowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return null;
        }
        if (node == p || node == q) {
            return node;
        }
        TreeNode leftResult = null, rightResult = null;
        if (node.left != null) {
            leftResult = lowestCommonAncestor(node.left, p, q);
        }
        if (node.right != null) {
            rightResult = lowestCommonAncestor(node.right, p, q);
        }
        if (leftResult != null && rightResult != null) {
            return node;
        } else if (leftResult == null) {
            return rightResult;
        } else {
            return leftResult;
        }
    }
}