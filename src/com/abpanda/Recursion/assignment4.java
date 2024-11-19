package com.abpanda.Recursion;

public class assignment4 {
//    Decimal to Binary
//    eg : 13 -> 13/2 : 1(rem) 6(quo) -> 6/2 | 0 -> 3/2 | 1 -> 1/2 | 1 -> 1101
//    f(n) : n mod 2  + 10*f(n/2)

    public static void main(String[] args) {
        int getbinary = convertToBinaryRecursion(13);
        System.out.println("Binary : " + getbinary);
    }

    public static int convertToBinaryRecursion(int a) {
        if (a == 0) {
            return 0;
        } else {
            return a % 2 + 10 *  convertToBinaryRecursion(a / 2);
        }
    }
}
