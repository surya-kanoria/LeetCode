import java.util.HashMap;
import java.util.HashSet;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        HashMap<Node, Node> copy = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            Node newNode = new Node(temp.val, null, null);
            copy.put(temp, newNode);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            Node copyNode = copy.get(temp);
            Node nextNode = temp.next != null ? copy.get(temp.next) : null;
            copyNode.next = nextNode;
            Node randomNode = temp.random != null ? copy.get(temp.random) : null;
            copyNode.random = randomNode;
            temp = temp.next;
        }
        return copy.get(head);
    }
}