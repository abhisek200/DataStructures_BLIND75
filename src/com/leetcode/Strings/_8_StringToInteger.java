package com.leetcode.Strings;

public class _8_StringToInteger {

    // Placeholder function for string to integer conversion (atoi)
    public int myAtoi(String s) {
        // Logic to convert string to integer will be implemented here

        int answer = 0;
        int sign = +1;
        int index = 0;
        String trimmed_s = s.trim();

        if (trimmed_s.length() == 0) {
            return 0;
        }

        if (trimmed_s.charAt(index) == '+') {
            index++;
        } else if (trimmed_s.charAt(index) == '-') {
            sign = -1;
            index++;
        }

        while (index < trimmed_s.length()) {
            char ch = trimmed_s.charAt(index);
            if (!Character.isDigit(ch)) {
                break;
            }

            int digit = ch - '0';

            if (answer > (Integer.MAX_VALUE - digit) / 10) {
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            answer = (answer * 10) + digit;
            index++;
        }
        return answer * sign;
    }

    public static void main(String[] args) {
        _8_StringToInteger solution = new _8_StringToInteger();

        // Test case 1
        String test1 = "42";
        System.out.println("Test Case 1: " + solution.myAtoi(test1)); // Expected output: 42

        // Test case 2
        String test2 = "   -042";
        System.out.println("Test Case 2: " + solution.myAtoi(test2)); // Expected output: -42

        // Test case 3
        String test3 = "1337c0d3";
        System.out.println("Test Case 3: " + solution.myAtoi(test3)); // Expected output: 1337

        // Test case 4
        String test4 = "0-1";
        System.out.println("Test Case 4: " + solution.myAtoi(test4)); // Expected output: 0

        // Test case 5
        String test5 = "words and 987";
        System.out.println("Test Case 5: " + solution.myAtoi(test5)); // Expected output: 0

        // Test case 6
        String test6 = "21474836460";
        System.out.println("Test Case 6: " + solution.myAtoi(test6)); // Expected output: 2147483647 (clamped to max int)

        // Test case 7
        String test7 = "-91283472332";
        System.out.println("Test Case 7: " + solution.myAtoi(test7)); // Expected output: -2147483648 (clamped to min int)

        // Test case 8
        String test8 = "  0000000000012345678";
        System.out.println("Test Case 8: " + solution.myAtoi(test8)); // Expected output: 12345678

        // Test case 9
        String test9 = "-+12";
        System.out.println("Test Case 9: " + solution.myAtoi(test9)); // Expected output: 0
    }
}
