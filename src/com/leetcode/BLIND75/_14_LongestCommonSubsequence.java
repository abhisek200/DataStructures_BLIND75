package com.leetcode.BLIND75; /* Created by abpanda on 21-11-2024 */

/*
Input: text1 = "abcde", text2 = "ace"
Output: 3
Explanation: The longest common subsequence is "ace" and its length is 3.
*/

public class _14_LongestCommonSubsequence {
    public static void main(String[] args) {
        String a = "abcde";
        String b = "ace";

        // 1st Approach: Using Recursion
        System.out.println("Longest Common Subsequence using Recursion: " +
                getLLCusingRecursion(a, b, a.length(), b.length()));

        // 2nd Approach: Using Memoization
        int[][] memo = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i <= a.length(); i++) {
            for (int j = 0; j <= b.length(); j++) {
                memo[i][j] = -1;
            }
        }
        System.out.println("Longest Common Subsequence using Memoization: " +
                getLLCusingMemoization(a, b, a.length(), b.length(), memo));

        // 3rd Approach: Using Dynamic Programming
        System.out.println("Longest Common Subsequence using DP: " +
                bestUsingDynamicAlgorithm(a, b));
    }

    // 1. Recursion
    /*
     * Recursive Solution:
     * - Time Complexity: O(2^(m + n))
     *   - For each character comparison, two recursive calls are made (include or exclude).
     * - Space Complexity: O(m + n)
     *   - The recursion stack depth is determined by the maximum of m or n.
     */
    static int getLLCusingRecursion(String a, String b, int i, int j) {
        if (i == 0 || j == 0) {
            return 0; // Base case: Empty string
        }
        if (a.charAt(i - 1) == b.charAt(j - 1)) {
            return 1 + getLLCusingRecursion(a, b, i - 1, j - 1); // Characters match
        } else {
            return Math.max(getLLCusingRecursion(a, b, i - 1, j), getLLCusingRecursion(a, b, i, j - 1));
        }
    }

    // 2. Memoization
    /*
     * :Memoization
     * - Time Complexity: O(m * n)
     *   - Each unique (i, j) pair is computed only once and stored in the memo table.
     * - Space Complexity: O(m * n)
     *   - Space required for the memo table + recursion stack.
     */
    static int getLLCusingMemoization(String a, String b, int i, int j, int[][] memo) {
        if (i == 0 || j == 0) {
            return 0; // Base case: Empty string
        }
        if (memo[i][j] != -1) {
            return memo[i][j]; // Return precomputed result
        }
        if (a.charAt(i - 1) == b.charAt(j - 1)) {
            memo[i][j] = 1 + getLLCusingMemoization(a, b, i - 1, j - 1, memo); // Characters match
        } else {
            memo[i][j] = Math.max(getLLCusingMemoization(a, b, i - 1, j, memo), getLLCusingMemoization(a, b, i, j - 1, memo));
        }
        return memo[i][j];
    }

    // 3. Dynamic Programming
    /*
     * Dynamic Programming:
     * - Time Complexity: O(m * n)
     *   - The table is filled once with each cell being calculated once.
     * - Space Complexity: O(m * n)
     *   - Space required for the DP table.
     *   - Can be further optimized to O(n) space using a rolling array technique.
     */
    static int bestUsingDynamicAlgorithm(String a, String b) {
        int m = a.length();
        int n = b.length();

        // Create DP table with size (m + 1) x (n + 1)
        int[][] dp = new int[m + 1][n + 1];

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1]; // Characters match, here i am doing top to bottom approach
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // Characters don't match, check adjacent matrix values
                }
            }
        }

        // Return the LCS length
        return dp[m][n]; //return last position, as everything will we maxed till we reach to bottom
    }
}
