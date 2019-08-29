import java.util.Stack;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class BSTIterator {
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        if (root != null) {
            TreeNode temp = root;
            do {
                System.out.println("push " + temp.val);
                stack.push(temp);
                temp = temp.left;
            } while (temp != null);
        }
    }

    /** @return the next smallest number */
    public int next() {
        System.out.println("next called");
        TreeNode node = stack.pop();
        System.out.println("pop 1" + node.val);
        if (node.right != null) {
            TreeNode temp = node.right;
            do {
                System.out.println("push " + temp.val);
                stack.push(temp);
                temp = temp.left;
            } while (temp != null);
        }
        System.out.println(node.val);
        return node.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.empty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such: BSTIterator
 * obj = new BSTIterator(root); int param_1 = obj.next(); boolean param_2 =
 * obj.hasNext();
 */