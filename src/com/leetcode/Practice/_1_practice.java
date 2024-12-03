package com.leetcode.Practice;

//Validate if the equation is syntactically correct.
//
//
//        Valid operators: +, -, a-z, (, )
//        Test cases:
//        Valid - a + x = b + (c + a)
//        Invalid - a + x = (ending with =; doesn't have RHS)
//        Invalid - a + -x = a + b (- in -x is a unary operator)

import java.util.Stack;

public class _1_practice {

    // Regular expression to match a valid expression with variables, operators, and parentheses
    private static final String VALID_EXPRESSION_REGEX = "^[a-z+\\-() ]+$";

    public static boolean isValidEquation(String equation) {
        // Check if equation contains exactly one '=' sign and split into LHS and RHS
        if (!equation.contains("=") || equation.indexOf('=') != equation.lastIndexOf('=')) {
            return false;
        }

        String[] sides = equation.split("=");
        if (sides.length != 2 || sides[0].trim().isEmpty() || sides[1].trim().isEmpty()) {
            return false; // Ensure both LHS and RHS are non-empty
        }
        return isValidExpression(sides[0].trim()) && isValidExpression(sides[1].trim());
    }

    private static boolean isValidExpression(String expression) {
        // Check if expression contains only valid characters
        if (!expression.matches(VALID_EXPRESSION_REGEX)) {
            return false;
        }

        // Check for consecutive or standalone operators (e.g., "a ++ b", "a + -x")
        if (expression.contains("++") || expression.contains("--") || expression.contains("+-") ||
                expression.contains("-+") || expression.matches(".*[+\\-]$") || expression.matches("^[+\\-].*")) {
            return false;
        }

        //        expression.matches(".*[+\\-]$")  -> "a + b +" or "a + b -"
        //        expression.matches("^[+\\-].*")  -> "+ a + b" or "- a + b"


        // Check for balanced parentheses using STACK
        Stack<Character> stack = new Stack<>();
        for (char c : expression.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false; // Unmatched closing parenthesis
                }
            }
        }

        return stack.isEmpty(); // All parentheses matched
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(isValidEquation("a + x = b + (c + a)")); // Expected: true
        System.out.println(isValidEquation("a + x ="));             // Expected: false
        System.out.println(isValidEquation("a + -x = a + b"));      // Expected: false
    }
}

