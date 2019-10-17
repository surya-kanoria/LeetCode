
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {

    public boolean isValidBST(TreeNode root) {
        return getIsValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean getIsValidBST(TreeNode node, long lowerBound, long upperBound) {
        if (node == null) {
            return true;
        } else {
            return (lowerBound < node.val && node.val < upperBound) && getIsValidBST(node.left, lowerBound, node.val)
                    && getIsValidBST(node.right, node.val, upperBound);
        }
    }
}