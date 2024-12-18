package com.leetcode.Tree.LeetCode;

import java.util.*;

public class _102_BinaryTreeLevelOrderTraversal {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) return resultList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.remove();
                currentList.add(currentNode.val);
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            resultList.add(currentList);
        }

        return resultList;
    }

    public static void main(String[] args) {
        _102_BinaryTreeLevelOrderTraversal solution = new _102_BinaryTreeLevelOrderTraversal();

        // Example 1
        TreeNode root1 = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7))
        );
        System.out.println("Level Order Traversal: " + solution.levelOrder(root1)); // Expected: [[3], [9, 20], [15, 7]]

        // Example 2
        TreeNode root2 = new TreeNode(1);
        System.out.println("Level Order Traversal: " + solution.levelOrder(root2)); // Expected: [[1]]

        // Example 3
        TreeNode root3 = null;
        System.out.println("Level Order Traversal: " + solution.levelOrder(root3)); // Expected: []
    }
}
