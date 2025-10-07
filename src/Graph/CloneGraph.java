package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {

    private static HashMap<Node, Node> map = new HashMap<>();

    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public static Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        if(map.containsKey(node)) {
            return map.get(node);
        }

        Node clone = new Node(node.val, new ArrayList<>());
        map.put(node, clone);
        for(Node n : node.neighbors) {
            clone.neighbors.add(cloneGraph(n));
        }

        return clone;
    }

    public static void main(String[] args) {
        int[][] adjList = {{2,4},{1,3},{2,4},{1,3}};
    }
}