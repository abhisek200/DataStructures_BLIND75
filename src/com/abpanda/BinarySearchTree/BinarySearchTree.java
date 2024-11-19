package com.abpanda.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    BinaryNode root;

    public BinarySearchTree() {
        root = null;
    }

    //insert
    private BinaryNode insert(BinaryNode currentNode, int value) {
        if (currentNode == null) {
            BinaryNode newNode = new BinaryNode();
            newNode.value = value;
            System.out.println(value + " Node Successfully Inserted!");
            return newNode;
        } else if (value <= currentNode.value) {
            currentNode.left = insert(currentNode.left, value);
            return currentNode;
        } else {
            currentNode.right = insert(currentNode.right, value);
            return currentNode;
        }
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    //DFS - PrOT (Preorder Traversal)
    // R -> LS -> RS
    public void preorderTraversal(BinaryNode node) {
        if (node == null) return;
        System.out.print(node.value + " ");
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    //DFS- In order Traversal (IOT)
    // LS -> R -> RS
    public void inorderTraversal(BinaryNode node) {
        if (node == null) return;
        inorderTraversal(node.left);
        System.out.print(node.value + " ");
        inorderTraversal(node.right);
    }

    //post order L->R->Root
    public void postorderTraversal(BinaryNode node) {
        if (node == null) return;
        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.print(node.value + " ");
    }

    //LevelOrder traversal
    public void levelOrderTraversal() {
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode current = queue.remove();
            System.out.print(current.value + " ");
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
    }

    public BinaryNode searchMyTress(BinaryNode node, int value) {
        if (node == null) {
            System.out.println("value doesn't exist");
            return null;
        } else if (node.value == value) {
            System.out.println(value + " provided value found in BST!");
            return node;
        } else if (value < node.value) {
            return searchMyTress(node.left, value);
        } else {
            return searchMyTress(node.right, value);
        }
    }

    public BinaryNode deleteValue(BinaryNode root, int value) {
        //case 1 - delete a leaf node
        //case 2 - node has one child
        //case 3 - node has 2 children (Successor node : smallest in Right subtree)
        if (root == null) {
            System.out.println("Value not found, get lost!");
            return null;
        }
        if (value < root.value) {
            root.left = deleteValue(root.left, value);
        } else if (value > root.value) {
            root.right = deleteValue(root.right, value);
        } else {
            //3 cases
            // when node is root (to delete)
            if (root.left != null && root.right != null) {
                BinaryNode tempNode = root;
                BinaryNode minimumFromRightSubTree = minimumNodeLeftSide(tempNode.right);
                root.value = minimumFromRightSubTree.value;
                root.right = deleteValue(root.right, minimumFromRightSubTree.value);
            }
            //1 child - left
            else if (root.left != null) {
                root = root.left;
            }
            //right
            else if (root.right != null) {
                root = root.right;
            } else {
                root = null; //will delete here
            }
        }
        return root;
    }

    //minimum node - finds the successor of the given node
    // min element in right subtree
    // min element will always be in LS of Root node RS
    public static BinaryNode minimumNodeLeftSide(BinaryNode root) {
        if (root.left == null) {
            return root;
        } else {
            return minimumNodeLeftSide(root.left);
        }
    }

    public void deleteEntireBST() {
        root = null;
        System.out.println("root has been null-ed, deleted the entire BST!");
    }
}
