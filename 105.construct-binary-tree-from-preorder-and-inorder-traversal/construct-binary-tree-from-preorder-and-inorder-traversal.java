/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return getTree(preorder, inorder, 0, 0, inorder.length);
    }

    private TreeNode getTree(int[] preorder, int[] inorder, int preorderIndex, int inOrderStart, int inorderEnd) {
        if (preorderIndex >= preorder.length || inOrderStart > inorderEnd) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[preorderIndex]);
        int i;
        for (i = inOrderStart; i < inorderEnd; i++) {
            if (inorder[i] == preorder[preorderIndex]) {
                break;
            }
        }
        node.left = getTree(preorder, inorder, preorderIndex + 1, inOrderStart, i - 1);
        node.right = getTree(preorder, inorder, preorderIndex + 1 - i - inOrderStart, i + 1, inorderEnd);
        return node;
    }
}