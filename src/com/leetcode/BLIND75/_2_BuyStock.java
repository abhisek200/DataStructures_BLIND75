package com.leetcode.BLIND75;

public class _2_BuyStock {
    public static void main(String[] args) {
        int prices[] = {7, 1, 5, 3, 6, 4};
        int profitStorer = 0;
        int minValueToBuyStonks = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minValueToBuyStonks) {
                minValueToBuyStonks = prices[i];
            }
            //calculate profit
            profitStorer = Math.max(profitStorer, prices[i] - minValueToBuyStonks);
        }
        System.out.println("Buy at : " + minValueToBuyStonks + " day");
        System.out.println("Profit : " + profitStorer);
    }
}
