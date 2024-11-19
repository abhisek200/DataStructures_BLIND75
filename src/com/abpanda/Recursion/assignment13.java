package com.abpanda.Recursion;

//    Given a string find its first uppercase letter
//
//    Example
//
//    Input : appmillerS
//    Output : S

public class assignment13 {

    public static void main(String[] args) {
        System.out.println("First uppercase letter: " + findFirstUppercase("appmillerS")); // Expected output: S
        System.out.println("First uppercase letter: " + findFirstUppercase("helloWorld"));  // Expected output: W
        System.out.println("First uppercase letter: " + findFirstUppercase("java"));        // Expected output: No uppercase letter found
    }

    public static String findFirstUppercase(String str) {
        char result = findFirstUppercaseHelper(str, 0);
        // Handle the case where no uppercase letter was found
        if (result == '\0') {
            return "No uppercase letter found";
        } else {
            return String.valueOf(result);
        }
    }

    private static char findFirstUppercaseHelper(String str, int index) {
        // Base case: if index reaches the length of the string, no uppercase letter is found
        if (index >= str.length()) {
            return '\0'; // Special character indicating no uppercase letter found
        }
        // Check if the character at the current index is uppercase
        if (Character.isUpperCase(str.charAt(index))) {
            return str.charAt(index);
        }
        // Recursive case: move to the next character
        return findFirstUppercaseHelper(str, index + 1);
    }

}