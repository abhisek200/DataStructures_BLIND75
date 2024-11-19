package com.abpanda.AVLTree;

import java.util.LinkedList;
import java.util.Queue;

public class AVL {
    public BinaryNodeAVL root;

    AVL() {
        root = null;
    }

    //PrOT
    void preorderTraversal(BinaryNodeAVL node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    //IOT
    void inOrderTraversal(BinaryNodeAVL node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.print(node + " ");
        inOrderTraversal(node.right);
    }

    //POsT
    void postOrderTraversal(BinaryNodeAVL node) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.value + " ");
    }

    //LOT - BFS
    void levelOrderTraversal() {
        Queue<BinaryNodeAVL> queue = new LinkedList<>();
        queue.add(root);
        BinaryNodeAVL node;
        while (!queue.isEmpty()) {
            node = queue.remove();
            System.out.print(node.value + " ");
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }

    //search
    BinaryNodeAVL searchInAVL(BinaryNodeAVL node, int value) {
        if (node == null) {
            System.out.println(value + " not found in AVL");
            return null;
        } else if (node.value == value) {
            System.out.println(value + " :Value found in AVL Tree.");
            return node;
        } else if (value < node.value) {
            return searchInAVL(node.left, value);
        } else {
            return searchInAVL(node.right, value);
        }
    }

    //INSERTION
    //4 Conditions : LL | LR | RR | RL

    //helper - getHeight
    public int getHeight(BinaryNodeAVL node) {
        if (node == null) return 0;
        return node.height;
    }

    private BinaryNodeAVL rotateRight(BinaryNodeAVL disbalancedNode) {
        BinaryNodeAVL newRoot = disbalancedNode.left;
        disbalancedNode.left = disbalancedNode.left.right;
        newRoot.right = disbalancedNode;
        disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    private BinaryNodeAVL rotateLeft(BinaryNodeAVL disbalancedNode) {
        BinaryNodeAVL newRoot = disbalancedNode.right;
        disbalancedNode.right = disbalancedNode.right.left;
        newRoot.left = disbalancedNode;
        disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    //getBalance if/not
    public int getBalancNode(BinaryNodeAVL node) {
        if (node == null) return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    //insert method
    private BinaryNodeAVL insertNode(BinaryNodeAVL node, int nodeValue) {
        if (node == null) {
            BinaryNodeAVL newNode = new BinaryNodeAVL();
            newNode.value = nodeValue;
            newNode.height = 1;
            System.out.println("New Node of nodeValue " + nodeValue + " is created.");
            return newNode;
        } else if (nodeValue < node.value) {
            node.left = insertNode(node.left, nodeValue);
        } else {
            node.right = insertNode(node.right, nodeValue);
        }
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        int balance = getBalancNode(node);
        if (balance > 1 && nodeValue < node.left.value) {
            //LL Condition
            return rotateRight(node);
        }
        if (balance > 1 && nodeValue > node.left.value) {
            //LR Condition
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        if (balance < -1 && nodeValue > node.right.value) {
            //RR condition
            return rotateLeft(node);
        }
        if (balance < -1 && nodeValue < node.right.value) {
            //LR condition
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
    }

    public void insert(int valueProvided) {
        root = insertNode(root, valueProvided);
    }

    //Delete
    //helper - Minimum Node
    public static BinaryNodeAVL minimumNode(BinaryNodeAVL root) {
        if (root.left == null) {
            return root;
        }
        return minimumNode(root.left);
    }

    //delete
    private BinaryNodeAVL deleteNode(BinaryNodeAVL node, int value) {
        // 2 cases - no rotation | rotation reqd.
        //first delete
        if (node == null) {
            System.out.println("Value not found in AVLTree x");
            return null;
        }
        if (value < node.value) {
            node.left = deleteNode(node.left, value);
        } else if (value > node.value) {
            node.right = deleteNode(node.right, value);
        } else {
            // check child nodes
            if (node.left != null && node.right != null) {
                BinaryNodeAVL tempNode = node;
                BinaryNodeAVL minimumForRSubTree = minimumNode(tempNode.right);
                node.value = minimumForRSubTree.value;
                node.right = deleteNode(node.right, minimumForRSubTree.value);
            } else if (node.left != null) {
                //only 1 child in left
                node = node.left;
            } else if (node.right != null) {
                //only 1 child in right
                node = node.right;
            } else {
                node = null;
            }
        }
        //check balanced or not
        int balance = getBalancNode(node);
        if (balance > 1 && getBalancNode(node.left) >= 0) {
            return rotateRight(node);
        }
        if (balance > 1 && getBalancNode(node.left) < 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        if (balance < -1 && getBalancNode(node.right) <= 0) {
            return rotateLeft(node);
        }
        if (balance < -1 && getBalancNode(node.right) > 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
    }

    public void deleteMeFromAVL(int value) {
        root = deleteNode(root, value); // O(log N) - Space | Time
        System.out.println("Deleted ? Yes or No, you decide!");
    }

    public void deleteEntireAVL() {
        root = null;
        System.out.println("Root deleted successfully so is the Tree.");
    }
}
