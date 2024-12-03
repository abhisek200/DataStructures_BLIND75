package com.abpanda.Dijkstra;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<WeightedGraphNode> nodeList = new ArrayList<>();
        nodeList.add(new WeightedGraphNode("A",0));
        nodeList.add(new WeightedGraphNode("B",1));
        nodeList.add(new WeightedGraphNode("C",2));
        nodeList.add(new WeightedGraphNode("D",3));
        nodeList.add(new WeightedGraphNode("E",4));
        nodeList.add(new WeightedGraphNode("F",5));
        nodeList.add(new WeightedGraphNode("G",6));

        WeightedGraphMain graph = new WeightedGraphMain(nodeList);
        graph.addWeightedNode(0,1,2);
        graph.addWeightedNode(0,2,5);
        graph.addWeightedNode(1,2,6);
        graph.addWeightedNode(1,3,1);
        graph.addWeightedNode(1,4,3);
        graph.addWeightedNode(2,5,8);
        graph.addWeightedNode(2,4,4);
        graph.addWeightedNode(4,6,9);
        graph.addWeightedNode(5,6,7);

        System.out.println("Printing Dijkstra from A : ");
        graph.dijkstra(nodeList.get(0));

    }
}
