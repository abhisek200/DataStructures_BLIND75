package com.leetcode.Tree.LeetCode;

import java.util.HashMap;

public class _105_ConstructBinaryTreeFromPreorderAndInorder {
    private HashMap<Integer, Integer> inorderHash;
    private int preOrderCounter;

    // Definition for a binary tree node
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length || preorder.length == 0) {
            return null; // Handle edge cases
        }

        // Initialize variables
        inorderHash = new HashMap<>();
        preOrderCounter = 0;

        // Populate the hash map with inorder indices
        for (int i = 0; i < inorder.length; i++) {
            inorderHash.put(inorder[i], i);
        }

        return constructTree(preorder, 0, inorder.length - 1);
    }

    private TreeNode constructTree(int[] preorder, int left, int right) {
        // Base case: if left > right, return null
        if (left > right) {
            return null;
        }

        // Get the root value from preorder
        int rootVal = preorder[preOrderCounter++];
        TreeNode root = new TreeNode(rootVal);

        // Get the index of the root in the inorder array
        int inorderIndex = inorderHash.get(rootVal);

        // Recursively build left and right subtrees
        root.left = constructTree(preorder, left, inorderIndex - 1);
        root.right = constructTree(preorder, inorderIndex + 1, right);

        return root;
    }

    public static void main(String[] args) {
        _105_ConstructBinaryTreeFromPreorderAndInorder solution = new _105_ConstructBinaryTreeFromPreorderAndInorder();

        // Example 1
        int[] preorder1 = {3, 9, 20, 15, 7};
        int[] inorder1 = {9, 3, 15, 20, 7};
        TreeNode root1 = solution.buildTree(preorder1, inorder1);
        System.out.println("Constructed Tree Root: " + (root1 != null ? root1.val : "null")); // Expected: 3

        // Example 2
        int[] preorder2 = {-1};
        int[] inorder2 = {-1};
        TreeNode root2 = solution.buildTree(preorder2, inorder2);
        System.out.println("Constructed Tree Root: " + (root2 != null ? root2.val : "null")); // Expected: -1
    }
}
