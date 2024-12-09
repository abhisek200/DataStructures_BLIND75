package com.leetcode.Strings;

public class _7_ReverseInteger {

    // Placeholder function to reverse the integer
    public static int reverse(int x) {
        int res = 0;
        int temp;
        while (x > 0) {
            int remainder = x % 10;
            temp = res * 10 + remainder;

            //edge case,  more than 32 bit will fail, verify the operation
            if (res != (temp - remainder) / 10) {
                //previous result == current temp reversed operation
                return 0;
            }
            x /= 10;
            res = temp;
        }
        return res; // Placeholder return
    }

    public static void main(String[] args) {
        // Test case 1
        int testCase1 = 123;
        System.out.println("Test Case 1: Input: " + testCase1 + " Output: " + reverse(testCase1));

        // Test case 2
        int testCase2 = -123;
        System.out.println("Test Case 2: Input: " + testCase2 + " Output: " + reverse(testCase2));

        // Test case 3
        int testCase3 = 120;
        System.out.println("Test Case 3: Input: " + testCase3 + " Output: " + reverse(testCase3));
    }
}

