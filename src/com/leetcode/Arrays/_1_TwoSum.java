package com.leetcode.Arrays;

import java.util.*;

public class _1_TwoSum {

    /**
     * Finds two numbers in the array that add up to the target and returns their indices.
     *
     * @param nums   Array of integers
     * @param target Target sum
     * @return Indices of the two numbers that add up to the target
     */


    public int[] twoSum(int[] nums, int target) {
        // TODO: Implement your logic here

        HashMap<Integer, Integer> mapValue = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (mapValue.containsValue(target - nums[i])) {
                return new int[]{mapValue.get(target - nums[i]), i};
            } else {
                mapValue.put(i, nums[i]);
            }
        }
        return null; // Placeholder return statement
    }

    public static void main(String[] args) {
        _1_TwoSum solver = new _1_TwoSum();

        // Test cases
        int[] testCase1 = {2, 7, 11, 15};
        int target1 = 9;
        assert Arrays.equals(solver.twoSum(testCase1, target1), new int[]{0, 1}) : "Failed Test 1";

        int[] testCase2 = {3, 2, 4};
        int target2 = 6;
        assert Arrays.equals(solver.twoSum(testCase2, target2), new int[]{1, 2}) : "Failed Test 2";

        int[] testCase3 = {3, 3};
        int target3 = 6;
        assert Arrays.equals(solver.twoSum(testCase3, target3), new int[]{0, 1}) : "Failed Test 3";

        System.out.println("All test cases passed!");
    }
}
