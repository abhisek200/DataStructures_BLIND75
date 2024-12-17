package com.leetcode.Tree.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

public class TreeStuff {

    //preorder traversal
    void preOrder(Node root) {
        if (root == null) return;
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    void inorderTraversal(Node root) {
        // L -> Root -> R
        if (root == null) return;
        inorderTraversal(root.left);
        System.out.println(root.val);
        inorderTraversal(root.right);
    }

    void postOrderTraversal(Node root) {
        // L -> R -> Root
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.val);
    }

    void doBFS(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node currentNode = queue.remove();
            System.out.println(currentNode.val);

            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
    }
}
