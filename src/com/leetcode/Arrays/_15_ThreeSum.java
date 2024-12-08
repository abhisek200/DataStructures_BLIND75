package com.leetcode.Arrays;

import java.util.*;

public class _15_ThreeSum {

    /**
     * Finds all unique triplets in the array that sum up to zero.
     *
     * @param nums Array of integers
     * @return List of unique triplets that sum up to zero
     */
    public List<List<Integer>> threeSum(int[] nums) {
        // TODO: Implement your logic here
        List<List<Integer>> resultList = new ArrayList<>();

        if (nums == null || nums.length < 3) {
            return null;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    resultList.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        _15_ThreeSum solver = new _15_ThreeSum();

        // Test case 1
        int[] testCase1 = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result1 = solver.threeSum(testCase1);
        System.out.println("Test Case 1: " + result1);

        // Test case 2
        int[] testCase2 = {0, 1, 1};
        List<List<Integer>> result2 = solver.threeSum(testCase2);
        System.out.println("Test Case 2: " + result2);

        // Test case 3
        int[] testCase3 = {0, 0, 0};
        List<List<Integer>> result3 = solver.threeSum(testCase3);
        System.out.println("Test Case 3: " + result3);
    }
}
