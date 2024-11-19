package com.abpanda.Recursion;

public class assignment1 {
//    sum of digits

    public static void main(String[] args) {
        int sum = sumOfDigitsUsingRecursion(123);
        System.out.println("sum of digits : " + sum);
    }

    public static int sumOfDigitsUsingRecursion(int n) {
        if (n == 0 || n < 0) return 0;
        return n % 10 + sumOfDigitsUsingRecursion(n / 10);
    }
}
