package com.leetcode.Arrays;


class _122_BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length-1; i++) {
            if (prices[i] < prices[i + 1]) {
                maxProfit += prices[i + 1] - prices[i];
            }

        }
        return maxProfit; // Placeholder return
    }

    public static void main(String[] args) {
        _122_BestTimeToBuyAndSellStock solution = new _122_BestTimeToBuyAndSellStock();

        int[] test1 = {7, 1, 5, 3, 6, 4};
        System.out.println(solution.maxProfit(test1));  // Expected output: 7

        int[] test2 = {1, 2, 3, 4, 5};
        System.out.println(solution.maxProfit(test2));  // Expected output: 4

        int[] test3 = {7, 6, 4, 3, 1};
        System.out.println(solution.maxProfit(test3));  // Expected output: 0

        int[] test4 = {1, 2, 4, 2, 5, 7, 2, 4, 9, 0};
        System.out.println(solution.maxProfit(test4));  // Expected output: 15

    }
}
