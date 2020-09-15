import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        Stack<TreeNode> traversalStack = new Stack<>();
        TreeNode curr = root;
        HashSet<TreeNode> traversed = new HashSet<>();
        while (curr != null) {
            if (curr.left != null && !traversed.contains(curr.left)) {
                traversalStack.push(curr);
                curr = curr.left;
            } else {
                traversal.add(curr.val);
                traversed.add(curr);
                if (curr.right != null) {
                    curr = curr.right;
                } else {
                    if (!traversalStack.isEmpty()) {
                        curr = traversalStack.pop();
                    } else {
                        curr = null;
                    }
                }
            }
        }
        return traversal;
    }
}