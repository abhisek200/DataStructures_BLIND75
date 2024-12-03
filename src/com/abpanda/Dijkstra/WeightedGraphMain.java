package com.abpanda.Dijkstra;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class WeightedGraphMain {
    ArrayList<WeightedGraphNode> nodeList = new ArrayList<>();

    WeightedGraphMain(ArrayList<WeightedGraphNode> nodeList) {
        this.nodeList = nodeList;
    }

    void dijkstra(WeightedGraphNode sourceNode) {
        PriorityQueue<WeightedGraphNode> queue = new PriorityQueue<>();
        sourceNode.distance = 0;
        queue.addAll(nodeList);

        while (!queue.isEmpty()) {
            WeightedGraphNode current = queue.remove();

            for (WeightedGraphNode neighbor : current.neighbours) {
                if (queue.contains(neighbor)) {
                    int newDistance = current.distance + current.weightMap.get(neighbor);
                    if (newDistance < neighbor.distance) {
                        neighbor.distance = newDistance;
                        neighbor.parent = current;
                        queue.remove(neighbor);
                        queue.add(neighbor); // refresh the queue
                    }
                }
            }
        }
        for (WeightedGraphNode node : nodeList) {
            System.out.println("Node : " + node + " distance : " + node.distance + " Path : ");
            pathPrint(node);
            System.out.println();
        }
    }

    void pathPrint(WeightedGraphNode node1) {
        if (node1.parent != null) {
            pathPrint((node1.parent));
        }
        System.out.print(node1.name + " ");
    }


    void addWeightedNode(int i, int j, int d) {
        WeightedGraphNode first = nodeList.get(i);
        WeightedGraphNode second = nodeList.get(j);
        first.neighbours.add(second);
        first.weightMap.put(second, d);

    }
}