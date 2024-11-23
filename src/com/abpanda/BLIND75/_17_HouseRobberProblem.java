package com.abpanda.BLIND75;

public class _17_HouseRobberProblem {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int maxMoney = rob(nums, 0); // recursion
        System.out.println("Maximum money you can rob: " + maxMoney);

        System.out.println("Using DP : " + robUSingDP(nums));
        System.out.println("Using DP2 (Memoization) : " + robUSingDP2(nums));
    }

    static int robUSingDP(int houses[]) {
        int rob1 = 0;
        int rob2 = 0;
        int max = 0;
        // [rob1, rob2, n, n+1, ....]
        for (int n : houses) {
            // we are only checking the max if we/don't rob the last one, whichever results max
            max = Math.max(n + rob1, rob2);
            rob1 = rob2;
            rob2 = max;
        }
        return max;
    }

    static int robUSingDP2(int houses[]) {
        int dp[] = new int[houses.length];
        dp[0] = houses[0];
        dp[1] = Math.max(dp[0], houses[1]);

        for (int i = 2; i < houses.length; i++) {
            dp[i] = Math.max(dp[i - 2] + houses[i], dp[i - 1]); // keep filling the max
        }
        return dp[houses.length - 1];
    }

    public static int rob(int[] nums, int index) {

        if (index >= nums.length) {
            return 0;
        }
        // Case 1: Rob this house (current house) and skip the adjacent house
        int robHouse = nums[index] + rob(nums, index + 2);
        // Case 2: Skip this house and move to the next one
        int skipHouse = rob(nums, index + 1);
        return Math.max(robHouse, skipHouse);
    }
}
