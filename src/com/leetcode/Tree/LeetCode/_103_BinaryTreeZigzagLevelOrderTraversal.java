package com.leetcode.Tree.LeetCode;

import java.util.*;

public class _103_BinaryTreeZigzagLevelOrderTraversal {
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            List<Integer> currentList = new ArrayList<>();
            for (int i = 0; i < queueSize; i++) {
                TreeNode currentNode = queue.remove();
                if (currentNode.left != null) queue.add(currentNode.left);
                if (currentNode.right != null) queue.add(currentNode.right);

                if (leftToRight) {
                    currentList.add(currentNode.val);
                } else {
                    currentList.add(0, currentNode.val);
                }
            }
            result.add(currentList);
            leftToRight = !leftToRight;
        }
        return result;
    }

    public static void main(String[] args) {
        _103_BinaryTreeZigzagLevelOrderTraversal solution = new _103_BinaryTreeZigzagLevelOrderTraversal();

        // Example 1
        TreeNode root1 = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7))
        );
        System.out.println("Zigzag Level Order Traversal: " + solution.zigzagLevelOrder(root1));
        // Expected: [[3], [20, 9], [15, 7]]

        // Example 2
        TreeNode root2 = new TreeNode(1);
        System.out.println("Zigzag Level Order Traversal: " + solution.zigzagLevelOrder(root2));
        // Expected: [[1]]

        // Example 3
        TreeNode root3 = null;
        System.out.println("Zigzag Level Order Traversal: " + solution.zigzagLevelOrder(root3));
        // Expected: []
    }
}
