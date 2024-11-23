package com.abpanda.BLIND75;

public class _18_HouseRobber2 {
    public static void main(String[] args) {
        int[] houses = {1, 2, 15, 11, 3, 6, 10};
        int result = rob(houses);
        System.out.println("Maximum money you can rob: " + result);
    }

    public static int rob(int[] houses) {
        // Edge case
        if (houses == null || houses.length == 0) {
            return 0;
        }
        if (houses.length == 1) {
            return houses[0];
        }

        // Case 1: Rob houses excluding the last house (from index 0 to n-2)
        int rob1 = robLinear(houses, 0, houses.length - 2);
        // Case 2: Rob houses excluding the first house (from index 1 to n-1)
        int rob2 = robLinear(houses, 1, houses.length - 1);

        // Using Memoization as before
        int rob3 = robMemoizationAlgo(houses, 0, houses.length - 2);
        int rob4 = robMemoizationAlgo(houses, 1, houses.length - 1);
        System.out.println("Max Money fetched (MEMOIZATION): " + Math.max(rob3, rob4));

        // Return the maximum value from both strategies
        return Math.max(Math.max(rob1, rob2), Math.max(rob3, rob4));
    }

    public static int robMemoizationAlgo(int houses[], int start, int end) {
        int[] dp = new int[houses.length];

        // Handle edge cases for small ranges
        if (start == end) {
            return 0; // No houses in this range
        }
        if (end - start == 1) {
            return houses[start]; // Only one house to rob
        }

        // Initialize base cases
        dp[start] = houses[start];
        dp[start + 1] = Math.max(houses[start], houses[start + 1]);

        // Fill dp array for the range [start, end)
        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 2] + houses[i], dp[i - 1]);
        }

        // Return the maximum money robbed in the range
        return dp[end];
    }

    private static int robLinear(int[] houses, int start, int end) {
        int rob1 = 0, rob2 = 0;

        // Loop through the houses in the specified range
        for (int i = start; i <= end; i++) {
            int maxMoney = Math.max(rob1 + houses[i], rob2);
            rob1 = rob2;
            rob2 = maxMoney;
        }
        // rob2 contains the maximum amount of money we can rob
        return rob2;
    }
}
