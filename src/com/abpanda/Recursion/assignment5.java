package com.abpanda.Recursion;

public class assignment5 {
//    power(2,2) // 4
//    power(2,4) // 16

    public static void main(String[] args) {
        int value = 2;
        int exponent = 4;
        int powerValue = getPower(value, exponent);
        System.out.println("Powervalue : " + powerValue);
    }

    public static int getPower(int value, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        return value * getPower(value, exponent - 1);
    }
}
