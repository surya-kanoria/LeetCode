import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        getRightSideView(root, 0, list);
        return list;
    }

    private void getRightSideView(TreeNode node, int currentLevel, List<Integer> list) {
        if (currentLevel == list.size()) {
            list.add(node.val);
        }
        if (node.right != null) {
            getRightSideView(node.right, currentLevel + 1, list);
        }
        if (node.left != null) {
            getRightSideView(node.left, currentLevel + 1, list);
        }
    }
}