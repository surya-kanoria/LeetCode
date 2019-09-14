/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> solution = new ArrayList();
        getLevelOrder(root, 0, solution);
        return solution;
    }

    private void getLevelOrder(TreeNode root, int level, List<List<Integer>> solution) {
        if (root == null) {
            return;
        }
        if (solution.size() <= level) {
            solution.add(level, new ArrayList<Integer>());
        }
        (solution.get(level)).add(root.val);
        getLevelOrder(root.left, level + 1, solution);
        getLevelOrder(root.right, level + 1, solution);
    }
}