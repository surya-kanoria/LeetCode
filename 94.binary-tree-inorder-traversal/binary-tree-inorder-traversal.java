
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> solution = new ArrayList<>();
        getInorderTraversal(root, solution);
        return solution;
    }

    private void getInorderTraversal(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        getInorderTraversal(node.left, result);
        result.add(node.val);
        getInorderTraversal(node.right, result);
    }
}