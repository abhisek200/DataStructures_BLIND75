package com.abpanda.Recursion;

public class assignment8 {
    public static void main(String[] args) {
        int recursiveSum = getSum(6);
        System.out.println("get sum : " + recursiveSum);
    }

    static int getSum(int a) {
        if (a < 0) {
            return 0;
        }
        return a + getSum(a - 1);
    }
}
