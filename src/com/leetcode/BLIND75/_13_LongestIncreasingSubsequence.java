package com.leetcode.BLIND75;

import java.util.Arrays;

public class _13_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int num[] = {10, 7, 8, 5, 16, 27, 9};
        System.out.println("Longest Increasing Subsequence Length : " + longestIncreasingSubsequence(num));
    }

    public static int longestIncreasingSubsequence(int[] nums) {
        int lis[] = new int[nums.length];
        Arrays.fill(lis, 1);
        int max = -1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    lis[i] = Math.max(lis[i], 1 + lis[j]); // recurrence relation
                    max = Math.max(max, lis[i]);
                }
            }
        }
        return max;

    }
}
