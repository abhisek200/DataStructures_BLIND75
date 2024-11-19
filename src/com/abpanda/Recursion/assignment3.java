package com.abpanda.Recursion;

public class assignment3 {

    //    Find GCD
//    gcd(8,12) -> 4
//    euclidean algo - > say 48,18 -> 48%18 rem:12 ; 18%12 rem:6 ; 12%6 rem:0 loop end
//    gcd(a,0) = a | gcd(a,b) = gcd(b, a mod b)
    public static void main(String[] args) {
        int a = 12, b = 4;
        int Divisor;
        if (a > b)
            Divisor = getGCDRecursion(a, b);
        else {
            Divisor = getGCDRecursion(b, a);
        }
        System.out.println("GCD is : " + Divisor);
    }

    public static int getGCDRecursion(int a, int b) {
        if (a < 0 || b < 0) return -1;
        if (b == 0)
            return a;
        return getGCDRecursion(b, a % b);
    }
}
