package com.leetcode.DynamicProgramming;

public class _121_BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {

        int maxProfit = 0;
        if (prices== null||prices.length <= 1) return 0;
        int low = prices[0];
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - low);
            low = Math.min(low, prices[i]);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        _121_BestTimeToBuyAndSellStock solution = new _121_BestTimeToBuyAndSellStock();

        // Example 1
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Maximum profit for prices1: " + solution.maxProfit(prices1));
        // Expected Output: 5

        // Example 2
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Maximum profit for prices2: " + solution.maxProfit(prices2));
        // Expected Output: 0

        // Additional test case
        int[] prices3 = {};
        System.out.println("Maximum profit for prices3: " + solution.maxProfit(prices3));
        // Expected Output: 0
    }
}
