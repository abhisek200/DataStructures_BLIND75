package com.abpanda.Recursion;

public class assignment6 {
//    factorial(4) // 24

    public static void main(String[] args) {
        int value = getfactorial(4);
        System.out.println("fact_value : " + value);
    }
    static int getfactorial(int value) {
        if (value == 1 || value == 0) return 1;
        return value * getfactorial(value - 1);
    }

}
