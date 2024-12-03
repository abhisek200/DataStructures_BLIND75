package com.leetcode.Arrays;

public class _26_removeDuplicates {

    public static void main(String[] args) {
        // Test case input
        int[] nums = {1, 1, 2, 3, 3, 4, 5}; // Input array
        int[] expectedNums = {1, 2, 3, 4, 5}; // Expected array of unique elements

        // Call the function (implementation is yet to be added)
        int k = removeDuplicates(nums); // Calls your implementation

        // Validate the result using assertions
        assert k == expectedNums.length : "The length of unique elements doesn't match.";

        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i] : "Mismatch at index " + i;
        }

        System.out.println("Test passed! Unique elements: " + k);
    }

    // Placeholder for your implementation
    public static int removeDuplicates(int[] nums) {
        int uniqueIndex=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[uniqueIndex]!=nums[i]){
                nums[uniqueIndex] = nums[i];
                uniqueIndex++;
            }
        }
        return uniqueIndex+1; // Temporary return
    }
}
