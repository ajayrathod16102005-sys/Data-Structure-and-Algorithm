import java.util.*;

class Solution {
    // Map original node -> cloned node
    private Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {

        // Empty graph
        if (node == null) {
            return null;
        }

        // If already cloned, return the clone
        if (map.containsKey(node)) {
            return map.get(node);
        }

        // Create clone of current node
        Node clone = new Node(node.val);
        map.put(node, clone);

        // Clone all neighbors
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }

        return clone;
    }
}