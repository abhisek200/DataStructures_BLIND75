package com.leetcode.Arrays;

import java.util.Arrays;

public class _66_PlusOne {

    public static void main(String[] args) {
        // Test case 1
        int[] digits1 = {1, 2, 3}; // Input array
        int[] expectedOutput1 = {1, 2, 4}; // Expected output
        validateTestCase(digits1, expectedOutput1);

        // Test case 2
        int[] digits2 = {4, 3, 2, 1};
        int[] expectedOutput2 = {4, 3, 2, 2};
        validateTestCase(digits2, expectedOutput2);

        // Test case 3
        int[] digits3 = {9};
        int[] expectedOutput3 = {1, 0};
        validateTestCase(digits3, expectedOutput3);

        System.out.println("All test cases passed!");
    }

    // Placeholder for the implementation
    public static int[] plusOne(int[] digits) {
        // normal scenario - 4, 3, 2, 1 -> 4, 3, 2, 2
        // if one element - 9 -> 1 0
        // if 9 - 4 4 9 9 -> 4 5 0 0

        int digitIndex = digits.length - 1;
        while (digits[digitIndex] == 9) {
            if (digitIndex == 0) {
                int[] newArr = new int[digits.length + 1];
                newArr[0] = 1;
                return newArr;
            }
            digits[digitIndex] = 0;
            digitIndex--;
        }
        digits[digitIndex] += 1;
        return digits; // Temporary return
    }

    // Validation method for test cases
    private static void validateTestCase(int[] input, int[] expectedOutput) {
        int[] result = plusOne(input); // Call the placeholder method
        assert Arrays.equals(result, expectedOutput) :
                "Test failed for input: " + Arrays.toString(input) + ". Expected: " + Arrays.toString(expectedOutput) + ", but got: " + Arrays.toString(result);
    }
}
