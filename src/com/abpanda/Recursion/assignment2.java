package com.abpanda.Recursion;

public class assignment2 {
    //    calculate power of n
//    x^n = x*x*x*x..(n times) = x * x^n-1
    public static void main(String[] args) {
        int power = getPowerrecursion(2, 4);
        System.out.println("Power : " + power);
    }

    public static int getPowerrecursion(int base, int exponent) {
        if (exponent == 1) {
            return base;
        }
        if(exponent < 0){
            return -1;
        }
        return base * getPowerrecursion(base, exponent - 1);
    }
}
