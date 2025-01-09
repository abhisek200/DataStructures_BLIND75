package com.leetcode.Tree.LeetCode;

public class _108_ConvertSortedArrayToBST {
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

    public TreeNode sortedArrayToBST(int[] nums) {
        return recurser(nums, 0, nums.length - 1);
    }

    public TreeNode recurser(int nums[], int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + (right)) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = recurser(nums, left, mid - 1);
        node.right = recurser(nums, mid + 1, right);

        return node;

    }

    public static void main(String[] args) {
        _108_ConvertSortedArrayToBST solution = new _108_ConvertSortedArrayToBST();

        // Example 1
        int[] nums1 = {-10, -3, 0, 5, 9};
        TreeNode bst1 = solution.sortedArrayToBST(nums1);
        System.out.println("BST from nums1: " + bst1); // Expected: [0,-3,9,-10,null,5] (or equivalent height-balanced BST)

        // Example 2
        int[] nums2 = {1, 3};
        TreeNode bst2 = solution.sortedArrayToBST(nums2);
        System.out.println("BST from nums2: " + bst2); // Expected: [3,1] or [1,null,3]
    }
}
