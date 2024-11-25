package com.abpanda.Graph;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<GraphNode> nodeList = new ArrayList<>();
        nodeList.add(new GraphNode("A", 0));
        nodeList.add(new GraphNode("B", 1));
        nodeList.add(new GraphNode("C", 2));
        nodeList.add(new GraphNode("D", 3));
        nodeList.add(new GraphNode("E", 4));
        Graph graph = new Graph(nodeList);
        graph.addUndirectedEdge(0, 1); // A->B | B->A
        graph.addUndirectedEdge(0, 2); // A->C
        graph.addUndirectedEdge(0, 3); // A->D
        graph.addUndirectedEdge(1, 4); // B->E
        graph.addUndirectedEdge(3, 4); // D->E
        graph.addUndirectedEdge(2, 3); // C->D
        System.out.println(graph.toString());
    }
}
