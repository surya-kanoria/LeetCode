/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    class Pair<T, V> {
        T left;
        V right;

        public T getLeft() {
            return this.left;
        }

        public V getRight() {
            return this.right;
        }

        public Pair(T left, V right) {
            this.left = left;
            this.right = right;
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        Pair<Integer, Integer> res = getKthSmallest(root, k);
        return res.getRight();
    }

    public Pair<Integer, Integer> getKthSmallest(TreeNode node, int k) {
        Pair<Integer, Integer> solution;
        if (k == 0) {
            solution = new Pair(0, node.val);
            return solution;
        }
        Pair<Integer, Integer> left = new Pair(0, -1), right = new Pair(0, -1);
        if (node.left != null) {
            left = getKthSmallest(node.left, k);
        }
        if (left.getRight() != -1) {
            return left;
        }
        if (left.getLeft() == (k - 1)) {
            solution = new Pair(0, node.val);
            return solution;
        }
        if (node.right != null) {
            right = getKthSmallest(node.right, (k - left.getLeft() - 1));
        }
        if (right.getRight() != -1) {
            return right;
        } else {
            solution = new Pair(left.getLeft() + right.getLeft() + 1, -1);
        }
        return solution;
    }
}