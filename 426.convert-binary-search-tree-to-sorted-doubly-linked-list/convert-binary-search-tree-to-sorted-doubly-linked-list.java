/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        Node linkedList = getRelevantNode(root, true);
        Node left = linkedList, right = linkedList;
        while (left.left != null) {
            System.out.println(left.val);
            left = left.left;
        }
        System.out.println("right");
        while (right.right != null) {
            System.out.println(right.val);
            right = right.right;
        }
        left.left = right;
        right.right = left;
        return left;
    }

    private Node getRelevantNode(Node node, boolean isLeft) {
        if (node.left == null && node.right == null) {
            return node;
        }
        if (node.left != null) {
            node.left = getRelevantNode(node.left, true);
            node.left.right = node;
        }
        if (node.right != null) {
            node.right = getRelevantNode(node.right, false);
            node.right.left = node;
        }
        if (isLeft) {
            if (node.right != null) {
                Node temp = node.right;
                while (temp.right != null) {
                    temp = temp.right;
                }
                return temp;
            }
        } else {
            if (node.left != null) {
                Node temp = node.left;
                while (temp.left != null) {
                    temp = temp.left;
                }
                return temp;
            }
        }
        return node;
    }
}