package com.abpanda.TopologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class GraphNode1 {
    public String name;
    public int index;
    public boolean isVisited = false;
    public ArrayList<GraphNode1> neighbors = new ArrayList<>();
    public GraphNode1 parent;

    GraphNode1(String name, int index) {
        this.name = name;
        this.index = index;
    }
}

public class TopSort {

    ArrayList<GraphNode1> nodeList = new ArrayList<>();

    TopSort(ArrayList<GraphNode1> nodeList) {
        this.nodeList = nodeList; // Use the provided nodeList
    }

    // Method to add undirected edges (not used in Topological Sort but kept for reference)
    void addUndirectedEdge(int i, int j) {
        GraphNode1 first = nodeList.get(i);
        GraphNode1 second = nodeList.get(j);
        first.neighbors.add(second);
        second.neighbors.add(first);
    }

    // Method to add directed edges (used for topological sorting)
    void addDirectedEdge(int i, int j) {
        GraphNode1 first = nodeList.get(i);
        GraphNode1 second = nodeList.get(j);
        first.neighbors.add(second); // Directed edge
    }

    // BFS method (not used in Topological Sort but kept for reference)
    private void doBFS(GraphNode1 node) {
        Queue<GraphNode1> queue = new LinkedList<>();
        queue.add(node);
        node.isVisited = true;
        while (!queue.isEmpty()) {
            GraphNode1 current = queue.remove();
            System.out.print(current.name);

            for (GraphNode1 neighbor : current.neighbors) {
                if (!neighbor.isVisited) {
                    queue.add(neighbor);
                    neighbor.isVisited = true;
                }
            }
        }
    }

    void BFSCall() {
        for (GraphNode1 node : nodeList) {
            if (node.isVisited) {
                doBFS(node);
            }
        }
    }

    // DFS method (not used in Topological Sort but kept for reference)
    private void doDFS(GraphNode1 node) {
        Stack<GraphNode1> stackMan = new Stack<>();
        stackMan.add(node);
        node.isVisited = true;

        while (!stackMan.isEmpty()) {
            GraphNode1 stackCurrentNode = stackMan.pop();
            System.out.print(stackCurrentNode.name);

            for (GraphNode1 neighbor : stackCurrentNode.neighbors) {
                if (!neighbor.isVisited) {
                    stackMan.add(neighbor);
                    neighbor.isVisited = true;
                }
            }
        }
    }

    void DFS() {
        for (GraphNode1 node : nodeList) {
            if (!node.isVisited) {
                doDFS(node);
            }
        }
    }

    private static void doTopoSort(GraphNode1 node, Stack<GraphNode1> stackMe) {
        node.isVisited = true; // Mark node as visited
        for (GraphNode1 neighbor : node.neighbors) {
            if (!neighbor.isVisited) {
                doTopoSort(neighbor, stackMe);
            }
        }
        stackMe.push(node); // Push node after visiting all neighbors
//        node.isVisited = true; //same as above
    }

    // Topological Sort method
    void TopoSort() {
        Stack<GraphNode1> stack = new Stack<>();
        // Perform Topological Sort
        for (GraphNode1 node : nodeList) {
            if (!node.isVisited) {
                doTopoSort(node, stack);
            }
        }
        // Print Topological Order
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().name + " ");
        }
        System.out.println(); // For cleaner output
    }

    void printSSSPP_path(GraphNode1 node1){
        if(node1!=null){
            printSSSPP_path((node1.parent));
        }
        System.out.print(node1.name + " ");
    }

    void SSSPP_usingBFS(GraphNode1 source){
        LinkedList<GraphNode1> queue = new LinkedList<>();
        queue.add(source);
        while(!queue.isEmpty()){
            GraphNode1 currentNode = queue.poll();
            currentNode.isVisited=true;
            System.out.print("Printing Path for Node " + currentNode.name + ": ");
            printSSSPP_path(currentNode); //get path till node from source
            System.out.println();
            for(GraphNode1 neighbor : currentNode.neighbors){
                neighbor.parent = currentNode;
                queue.add(neighbor);
                neighbor.isVisited = true;
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<GraphNode1> nodeList = new ArrayList<>();
        nodeList.add(new GraphNode1("A", 0));
        nodeList.add(new GraphNode1("B", 1));
        nodeList.add(new GraphNode1("C", 2));
        nodeList.add(new GraphNode1("D", 3));
        nodeList.add(new GraphNode1("E", 4));

        TopSort g = new TopSort(nodeList);
        // To make it work, remove undirected edges and add directed ones instead:
        g.addDirectedEdge(0, 1); // A -> B
        g.addDirectedEdge(0, 2); // A -> C
        g.addDirectedEdge(1, 3); // B -> D
        g.addDirectedEdge(2, 3); // C -> D
        g.addDirectedEdge(3, 4); // D -> E

        // Perform and print Topological Sort
        System.out.println("Topological Sort:");
        g.TopoSort();
    }
}
