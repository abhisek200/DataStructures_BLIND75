package com.abpanda.BLIND75;

/*
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.*/

import java.util.Arrays;

public class _20_UniquePaths {
    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        System.out.println("UniquePaths using DP : " + uniquePaths(m, n));
    }

    public static int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, 1);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
