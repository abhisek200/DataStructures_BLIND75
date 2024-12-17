package com.leetcode.Tree.LeetCode;

import java.util.Stack;

public class _98_ValidBinarySearchTree {
    Stack<Integer> stack = new Stack<>();

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isValidBST(TreeNode root) {

        // Do Inorder Traversal
        doInorder(root);

        while (!stack.isEmpty()) {
            int element = stack.pop();

            if (stack.isEmpty())
                return true;
            if (element <= stack.peek()) {
                return false;
            }
        }
        return true;
    }

    // Helper function to perform inorder traversal and store values in stack
    void doInorder(TreeNode root) {
        if (root != null) {
            doInorder(root.left);
            stack.push(root.val);
            doInorder(root.right);
        }
    }

    public static void main(String[] args) {
        _98_ValidBinarySearchTree solution = new _98_ValidBinarySearchTree();

        // Test case 1: Valid BST
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);
        System.out.println("Test case 1: " + solution.isValidBST(root1)); // Expected: true

        // Test case 2: Invalid BST (Right child is less than root)
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);
        System.out.println("Test case 2: " + solution.isValidBST(root2)); // Expected: false

        // Test case 3: Single node (Trivially valid)
        TreeNode root3 = new TreeNode(1);
        System.out.println("Test case 3: " + solution.isValidBST(root3)); // Expected: true

        // Test case 4: Invalid BST (Left child is greater than root)
        TreeNode root4 = new TreeNode(10);
        root4.left = new TreeNode(12);
        root4.right = new TreeNode(15);
        System.out.println("Test case 4: " + solution.isValidBST(root4)); // Expected: false

        // Test case 5: Valid BST (large tree)
        TreeNode root5 = new TreeNode(20);
        root5.left = new TreeNode(10);
        root5.right = new TreeNode(30);
        root5.left.left = new TreeNode(5);
        root5.left.right = new TreeNode(15);
        root5.right.left = new TreeNode(25);
        root5.right.right = new TreeNode(35);
        System.out.println("Test case 5: " + solution.isValidBST(root5)); // Expected: true
    }
}
