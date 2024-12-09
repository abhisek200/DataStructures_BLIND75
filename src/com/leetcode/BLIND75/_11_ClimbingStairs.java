package com.leetcode.BLIND75;

public class _11_ClimbingStairs {
    public static void main(String[] args) {
        //takes n step to reach the staircase
        //n=3
        //3 ways : 1+1+1 / 2+1 / 1+2 : 3 distinct ways
        int n1 = 5;
        System.out.println("Recursive solution answer : " + recursiveSolution(n1));
        System.out.println("Efficient solution no of ways : " + efficientSolution(n1));
    }

    public static int efficientSolution(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        int oneStep = 1;
        int twoStep = 2;
        int total = 0;

        for (int i = 3; i <= n; i++) {
            total = oneStep + twoStep;
            oneStep = twoStep; // Move `twoStep` to `oneStep`
            twoStep = total;   // Move `total` to `twoStep`
        }

        return total;
    }

    public static int recursiveSolution(int n) {
//        n = 5; // 8 ways
        if (n == 1 || n == 0) {
            return 1;
        }
        return recursiveSolution(n - 1) + recursiveSolution(n - 2);
    }
}
