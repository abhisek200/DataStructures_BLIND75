package com.leetcode.BLIND75;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Node {
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

public class _22_CloneGraph {
    private HashMap<Node, Node> hasVisited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null; // Handle edge case of empty graph
        }

        // If the node has already been cloned, return the clone
        if (hasVisited.containsKey(node)) {
            return hasVisited.get(node);
        }

        // Clone the node (without its neighbors initially)
        Node cloneNode = new Node(node.val, new ArrayList<>());

        // Store the clone in the visited map
        hasVisited.put(node, cloneNode);

        // Recursively clone the neighbors
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }

        return cloneNode;
    }

    public static void main(String[] args) {
        // Example graph creation
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        // Connect the graph
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        // Clone the graph
        _22_CloneGraph solution = new _22_CloneGraph();
        Node clonedGraph = solution.cloneGraph(node1);

        // Verify the result
        System.out.println("Original Node Value: " + node1.val);
        System.out.println("Cloned Node Value: " + clonedGraph.val);

        System.out.println("Original Node Neighbors:");
        for (Node neighbor : node1.neighbors) {
            System.out.print(neighbor.val + " ");
        }

        System.out.println("\nCloned Node Neighbors:");
        for (Node neighbor : clonedGraph.neighbors) {
            System.out.print(neighbor.val + " ");
        }
    }
}
