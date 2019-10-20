import java.util.HashMap;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();
        createHashMap(node, map);
        getClonedGraph(node, map);
        Node copy = map.get(node);
        System.out.println(copy.val);
        for (Node temp : copy.neighbors) {
            System.out.println(temp.val);
        }
        return map.get(node);
    }

    private void createHashMap(Node node, HashMap<Node, Node> map) {
        if (node != null) {
            map.put(node, new Node(node.val, null));
        }
        if (node.neighbors != null) {
            for (Node neighbor : node.neighbors) {
                if (!map.containsKey(neighbor)) {
                    createHashMap(neighbor, map);
                }
            }
        }
    }

    private void getClonedGraph(Node node, HashMap<Node, Node> map) {
        Node newNode = map.get(node);
        if (newNode.neighbors == null) {
            newNode.neighbors = new ArrayList();
            for (Node neighbor : node.neighbors) {
                newNode.neighbors.add(map.get(neighbor));
            }
            for (Node neighbor : node.neighbors) {
                getClonedGraph(neighbor, map);
            }
        }
    }
}