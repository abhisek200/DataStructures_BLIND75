package com.abpanda.BinaryTreeQuestions;

public class BasicBTree {
    private class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
            left = right = null;
        }
    }

    private Node root;

    public void add(int value) {
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        }
        return current; //if same value - no duplicates - return same
    }

    public void traverseInOrder() {
        System.out.println("In Order Traversal LST -> RN -> RST");
        traverseInOrderRecursive(root);
        System.out.println();
    }

    private void traverseInOrderRecursive(Node nodeObject) {
        if (nodeObject != null) {
            traverseInOrderRecursive(nodeObject.left);
            System.out.print(nodeObject.value + " ");
            traverseInOrderRecursive(nodeObject.right);
        }
    }

    public static void main(String[] args) {
        BasicBTree BTRE = new BasicBTree();
        BTRE.add(12);
        BTRE.add(13);
        BTRE.add(1212);
        BTRE.add(1421);
        BTRE.add(1212);
        BTRE.add(1221);
        BTRE.traverseInOrder();
    }
}
