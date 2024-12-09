package com.leetcode.Strings;

public class _344_ReverseString {

    // Placeholder function to reverse the string
    public static void reverseString(char[] s) {
        // Logic to be implemented by the user

        for (int i = 0; i < s.length/2; i++) {
            char temp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = temp;
        }
    }

    public static void main(String[] args) {
        // Test case 1
        char[] testCase1 = {'h', 'e', 'l', 'l', 'o'};
        reverseString(testCase1);
        System.out.println("Test Case 1: " + java.util.Arrays.toString(testCase1));

        // Test case 2
        char[] testCase2 = {'H', 'a', 'n', 'n', 'a', 'h'};
        reverseString(testCase2);
        System.out.println("Test Case 2: " + java.util.Arrays.toString(testCase2));
    }
}
