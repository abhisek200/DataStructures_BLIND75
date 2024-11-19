package com.abpanda.BinaryHeap;

public class Main {
    public static void main(String[] args) {
        BinaryHeap BHeap = new BinaryHeap(5);
        BHeap.insert(10, "MIN");
        BHeap.insert(5, "MIN");
        BHeap.insert(15, "MIN");
        BHeap.insert(1, "MIN");
        BHeap.levelOrderTraversal();
        BHeap.extractHeadOfBinaryHeap("MIN");
        System.out.println(BHeap.sizeOfTree);
        BHeap.levelOrderTraversal();
    }
}
