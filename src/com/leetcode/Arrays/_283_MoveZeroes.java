package com.leetcode.Arrays;

import java.util.Arrays;

public class _283_MoveZeroes {

    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {0, 1, 0, 3, 12};
        int[] expectedOutput1 = {1, 3, 12, 0, 0};
        validateTestCase(nums1, expectedOutput1);

        // Test case 2
        int[] nums2 = {0};
        int[] expectedOutput2 = {0};
        validateTestCase(nums2, expectedOutput2);

        // Test case 3
        int[] nums3 = {1, 0, 2, 0, 3};
        int[] expectedOutput3 = {1, 2, 3, 0, 0};
        validateTestCase(nums3, expectedOutput3);

        System.out.println("All test cases passed!");
    }

    // Placeholder for the implementation
    public static void moveZeroes(int[] nums) {
        // Your logic will go here
//        int[] nums3 = {1, 0, 2, 0, 3};
//        int[] expectedOutput3 = {1, 2, 3, 0, 0};
        int left, right;
        left = 0;
        if (nums.length == 1) {
            return;
        }
        for (int i = 1; i < nums.length; i++) {
            right = i;
            if (nums[left] == 0 && nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = 0;
                left++;
            } else if (nums[right] == 0 && nums[left] != 0) {
                left++;
                continue;
            } else if (nums[right] == 0 && nums[left] == 0) {
                left++;
                continue;
            }
        }

    }

    // Validation method for test cases
    private static void validateTestCase(int[] input, int[] expectedOutput) {
        moveZeroes(input); // Call the placeholder method
        assert Arrays.equals(input, expectedOutput) :
                "Test failed for input: " + Arrays.toString(input) + ". Expected: " + Arrays.toString(expectedOutput) + ", but got: " + Arrays.toString(input);
    }
}
