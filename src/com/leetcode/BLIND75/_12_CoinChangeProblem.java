package com.leetcode.BLIND75;

import java.util.Arrays;

public class _12_CoinChangeProblem {
    public static void main(String[] args) {
        int coins[] = {1, 3, 5, 6};
        int amount = 11;
        System.out.println("Resultant amount : " + coinChangeDP(coins, amount));
    }

    public static int coinChangeDP(int coins[], int amount) {
        int amt[] = new int[amount + 1];
        Arrays.fill(amt, amount + 1); // if we cannot create a amount we return -1
        amt[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    amt[i] = Math.min(amt[i], 1 + amt[i - coins[j]]);
                }
            }
        }
        if (amt[amount] < amount + 1) return amt[amount];
        else {
            return -1;
        }
    }
}
