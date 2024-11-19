package com.abpanda.Recursion;

public class assignment9 {
//    Write a recursive function called fib which accepts a number and returns the nth number
//    in the Fibonacci sequence. Recall that the Fibonacci sequence is the sequence of whole numbers
//    0,1, 1, 2, 3, 5, 8, ... which starts with 0 and 1, and where every number thereafter is equal to the
//    sum of the previous two numbers.
//
//            Examples
//
//    fib(4) # 3
//    fib(10) # 55
//    fib(28) # 317811
//    fib(35) # 9227465

    public static void main(String[] args) {
        System.out.println("Fibonacci of 4: " + fib(4));    // Expected output: 3
        System.out.println("Fibonacci of 10: " + fib(10));  // Expected output: 55
        System.out.println("Fibonacci of 28: " + fib(28));  // Expected output: 317811
        System.out.println("Fibonacci of 35: " + fib(35));  // Expected output: 9227465
    }

    public static int fib(int n) {
        // Base cases: the 0th Fibonacci number is 0, and the 1st is 1
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        // Recursive case: sum of the two preceding Fibonacci numbers
        return fib(n - 1) + fib(n - 2);
    }
}
