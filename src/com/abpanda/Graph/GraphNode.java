package com.abpanda.Graph;

public class GraphNode {
    public String name;
    public int index;
    boolean isVisited = false;

    public GraphNode(String name, int index) {
        this.name = name;
        this.index = index;
    }
}
