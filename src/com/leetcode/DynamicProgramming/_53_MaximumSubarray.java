package com.leetcode.DynamicProgramming;

public class _53_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        // Placeholder for main logic to find the maximum subarray sum

        // Ensure input validation
        if (nums == null || nums.length == 0) {
            return 0; // Placeholder for edge case return
        }

        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (currentSum < 0) {
                currentSum = nums[i];
            } else {
                currentSum += nums[i];
            }
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        _53_MaximumSubarray solution = new _53_MaximumSubarray();

        // Example test cases
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum Subarray Sum for nums1: " + solution.maxSubArray(nums1));
        // Expected Output: 6

        int[] nums2 = {1};
        System.out.println("Maximum Subarray Sum for nums2: " + solution.maxSubArray(nums2));
        // Expected Output: 1

        int[] nums3 = {5, 4, -1, 7, 8};
        System.out.println("Maximum Subarray Sum for nums3: " + solution.maxSubArray(nums3));
        // Expected Output: 23
    }
}
