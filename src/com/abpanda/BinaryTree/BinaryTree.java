package com.abpanda.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    BinaryNode root;

    public BinaryTree() {
        this.root = null;
    }

    //pre-order traversal
    public void preOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.value + " "); //root
        preOrder(node.Left); //Left
        preOrder(node.Right); //Right
    }

    //inorder traversal
    public void inOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.Left); //left
        System.out.println(node.value + " "); //root
        inOrder(node.Right); //right
    }

    //post-order traversal
    public void postorder(BinaryNode node) {
        if (node == null) {
            return;
        }
        postorder(node.Left);
        postorder(node.Right);
        System.out.println(node.value + " ");
    }

    //level-order traversal using Queue-approach
    public void levelOrder() {
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();
            System.out.print(presentNode.value + " ");
            if (presentNode.Left != null) {
                queue.add(presentNode.Left);
            }
            if (presentNode.Right != null) {
                queue.add(presentNode.Right);
            }
        }
    }

    //search using LevelOrderTraversal
    public void search(String value) {
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();
            if (presentNode.value == value) {
                System.out.println("Value " + value + " Found in Tree!");
                return;
            } else {
                if (presentNode.Left != null) {
                    queue.add(presentNode.Left);
                }
                if (presentNode.Right != null) {
                    queue.add(presentNode.Right);
                }
            }
        }
        System.out.println("Value " + value + " not found in Tree.");
    }

    //insert a node - in BTree : it is following Level Order Traversal and checks the LNode then RNode
    //insert method
    void insert(String value) {
        BinaryNode newNode = new BinaryNode();
        newNode.value = value;
        if (this.root == null) {
            root = newNode;
            System.out.println("Inserted new Node at root of value = " + value);
            return;
        }
        //search for vacant places using L.O.Traversal
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();
            if (presentNode.Left == null) {
                presentNode.Left = newNode;
                System.out.println("Successfully inserted at Left Node");
                break;
            }
            if (presentNode.Right == null) {
                presentNode.Right = newNode;
                System.out.println("Successfully inserted at Right Node");
                break;
            } else {
                queue.add(presentNode.Left);
                queue.add(presentNode.Right); //this makes a loop and continuous
            }
        }
    }

    //delete a node - using Level Order Traversal
    public void deleteNode(String value) {
        if (root == null) {
            System.out.println("Invalid BTree");
            return;
        }
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();
            if (presentNode.value == value) {
                presentNode.value = getDeepestNode().value;
                deleteDeepestNode();
                System.out.println("Node is Deleted of Value : " + value);
            } else {
                if (presentNode.Left != null) {
                    queue.add(presentNode.Left);
                }
                if (presentNode.Right != null) {
                    queue.add(presentNode.Right);
                }
            }
        }
        System.out.println("The node does not exist in the BTree, provide a correct value!");
    }

    public BinaryNode getDeepestNode() {
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        BinaryNode presentNode = null;
        while (!queue.isEmpty()) {
            presentNode = queue.remove();
            if (presentNode.Left != null) {
                queue.add(presentNode.Left);
            }
            if (presentNode.Right != null) {
                queue.add(presentNode.Right);
            }
        }
        System.out.println("Returned value at getDeepestNode : " + presentNode.value);
        return presentNode; //has the deepest node in Tree
    }

    public void deleteDeepestNode() {
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        BinaryNode previousNode, presentNode = null;
        while (!queue.isEmpty()) {
            previousNode = presentNode;
            presentNode = queue.remove();
            if (presentNode.Left == null) {
                //means previous node right was deepest node
                System.out.println("Deleted value : " + presentNode.Right.value);
                previousNode.Right = null;
                return;
            }
            if (presentNode.Right == null) {
                System.out.println("Deleted value : " + presentNode.Left.value);
                presentNode.Left = null;
                return;
            }
            queue.add(presentNode.Left);
            queue.add(presentNode.Right);
        }
    }

    //delete entire BTREE
    void deleteEntireBtree() {
        root = null;
        System.out.println("root is null and BTree is successfully deleted.");
    }
}