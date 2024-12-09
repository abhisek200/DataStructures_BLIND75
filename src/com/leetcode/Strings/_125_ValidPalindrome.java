package com.leetcode.Strings;

public class _125_ValidPalindrome {

    // Placeholder function to check if a string is a valid palindrome
    public boolean isPalindrome(String s) {
        // Logic to check for a valid palindrome will be implemented here

        String strFinal = "";
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                strFinal += s.charAt(i);
            }
        }
        strFinal = strFinal.toLowerCase();

        for (int i = 0; i < strFinal.length() / 2; i++) {
            if (strFinal.charAt(i) != strFinal.charAt(strFinal.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        _125_ValidPalindrome solution = new _125_ValidPalindrome();

        // Test case 1
        String s1 = "A man, a plan, a canal: Panama";
        System.out.println("Test Case 1: " + solution.isPalindrome(s1)); // Expected output: true

        // Test case 2
        String s2 = "race a car";
        System.out.println("Test Case 2: " + solution.isPalindrome(s2)); // Expected output: false

        // Test case 3
        String s3 = " ";
        System.out.println("Test Case 3: " + solution.isPalindrome(s3)); // Expected output: true

        // Additional Test case 4
        String s4 = "abcba";
        System.out.println("Test Case 4: " + solution.isPalindrome(s4)); // Expected output: true

        // Additional Test case 5
        String s5 = "abccba";
        System.out.println("Test Case 5: " + solution.isPalindrome(s5)); // Expected output: true

        // Additional Test case 6
        String s6 = "abccbx";
        System.out.println("Test Case 6: " + solution.isPalindrome(s6)); // Expected output: false
    }
}
