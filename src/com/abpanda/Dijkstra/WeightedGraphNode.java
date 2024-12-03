package com.abpanda.Dijkstra;

import java.util.ArrayList;
import java.util.HashMap;

public class WeightedGraphNode implements Comparable<WeightedGraphNode> {
    public String name;
    int index;
    int distance;
    WeightedGraphNode parent;
    boolean isVisited = false;
    ArrayList<WeightedGraphNode> neighbours = new ArrayList<WeightedGraphNode>();
    HashMap<WeightedGraphNode, Integer> weightMap = new HashMap<>();

    WeightedGraphNode(String name, int index) {
        this.name = name;
        this.index = index;
        this.distance = Integer.MAX_VALUE;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int compareTo(WeightedGraphNode node) {
        return this.distance - node.distance;
        //node with the smallest distance is placed at the first.
    }
}

/*
Yes, with the Comparable implementation, your PriorityQueue ensures nodes are stored and processed based on their distance.
The smallest distance node will always be at the front, as required by Dijkstra's algorithm.*/
