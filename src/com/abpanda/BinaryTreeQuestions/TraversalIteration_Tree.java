package com.abpanda.BinaryTreeQuestions;

import java.util.Stack;

public class TraversalIteration_Tree {
    private class Node {
        private int value;
        private Node Left;
        private Node Right;

        public Node(int value) {
            this.value = value;
            Left = Right = null;
        }
    }

    private Node root;

    public void add(int value) { //sets the root node
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new TraversalIteration_Tree.Node(value); //set new value
        }
        if (value < current.value) {
            current.Left = addRecursive(current.Left, value);
        }
        if (value > current.value) {
            current.Right = addRecursive(current.Right, value);
        }
        return current;
    }

    public void inOrderIteration() {
        Stack<Node> stack = new Stack(); //stack of node type
        Node current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.Left;
            }
            current = stack.pop();
            System.out.print(current.value + " ");
            current = current.Right;
        }
    }

    public void preOrderTraversalIteration() {
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        Node current;
        stack.push(root);
        while (!stack.isEmpty()) {
            current = stack.pop();
            System.out.print(current.value + " ");
            if (current.Right != null) {
                stack.push(current.Right);
            }
            if (current.Left != null) {
                stack.push(current.Left);
            }
        }
    }

    public void postOrderTraversal() {
        Node node;
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        if (root != null) s1.push(root);
        while (!s1.isEmpty()) {
            node = s1.pop();
            s2.push(node);
            if (node.Left != null) s1.push(node.Left);
            if (node.Right != null) s1.push(node.Right);
        }
        while (!s2.isEmpty()) {
            Node node2 = s2.pop();
            System.out.print(node2.value + " ");
        }
    }

    public static void main(String[] args) {
        TraversalIteration_Tree tt = new TraversalIteration_Tree();
        tt.add(1);
        tt.add(2);
        tt.add(3);
        tt.add(4);
        tt.add(5);
        tt.add(6);
        tt.add(7);
        tt.preOrderTraversalIteration();
    }

}
