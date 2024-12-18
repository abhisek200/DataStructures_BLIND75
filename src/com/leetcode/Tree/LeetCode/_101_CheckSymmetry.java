package com.leetcode.Tree.LeetCode;

public class _101_CheckSymmetry {

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

    // Method to check symmetry recursively
    public boolean isSymmetricRecursive(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    // Helper method for recursive symmetry check
    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }


    // Main method for testing
    public static void main(String[] args) {
        _101_CheckSymmetry solution = new _101_CheckSymmetry();

        // Example Tree 1
        TreeNode root1 = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(4), new TreeNode(3))
        );
        System.out.println("Is Tree 1 Symmetric? " + solution.isSymmetricRecursive(root1)); // Expected: true

        // Example Tree 2
        TreeNode root2 = new TreeNode(1,
                new TreeNode(2, null, new TreeNode(3)),
                new TreeNode(2, null, new TreeNode(3))
        );
        System.out.println("Is Tree 2 Symmetric? " + solution.isSymmetricRecursive(root2)); // Expected: false
    }
}
