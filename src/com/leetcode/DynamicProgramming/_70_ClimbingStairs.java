package com.leetcode.DynamicProgramming;

import java.util.HashMap;

public class _70_ClimbingStairs {


    public int climbStairs(int n) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        if (n == 1 || n == 0) {
            return 1;
        }
        if (hashMap.containsKey(n)) {
            return hashMap.get(n);
        } else {
            hashMap.put(n, climbStairs(n - 1) + climbStairs(n - 2));
        }
        return hashMap.get(n);
    }

    public static void main(String[] args) {
        _70_ClimbingStairs solution = new _70_ClimbingStairs();

        // Example 1
        int n1 = 2;
        System.out.println("Number of ways to climb " + n1 + " stairs: " + solution.climbStairs(n1));
        // Expected Output: 2

        // Example 2
        int n2 = 3;
        System.out.println("Number of ways to climb " + n2 + " stairs: " + solution.climbStairs(n2));
        // Expected Output: 3

        // Additional test cases
        int n3 = 0;
        System.out.println("Number of ways to climb " + n3 + " stairs: " + solution.climbStairs(n3));
        // Expected Output: 0
    }
}
