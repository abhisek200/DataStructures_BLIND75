package com.abpanda.BLIND75;

/*
For example, "11106" can be decoded into:

        "AAJF" with the grouping (1, 1, 10, 6)
"KJF" with the grouping (11, 10, 6)
The grouping (1, 11, 06) is invalid because "06" is not a valid code (only "6" is valid).*/

public class _19_DecodeWays {
    public static void main(String[] args) {
        String s1 = "122016";
        String s = "2128";
        System.out.println("Max ways to decode " + s + " using DP_O(n) : " + decodeUsingDP(s));
        System.out.println("Max ways to decode " + s + " using DP_O(n) better one : " + decodeUsingDP_better(s));
        System.out.println("Max ways to decode " + s + " using recursion with memoization O(n) : " + decodeUsingRecursionMemoization(s));
        System.out.println("Max ways to decode " + s + " using recursion (2^n) : " + decodeWaysRecursive(s, s.length()));
        System.out.println("Max ways to decode " + s + " using recursion2 (2^n) : " + decodeWaysRecursion_2(s, 0));


    }

    //best
    public static int decodeUsingDP(String s) {
        int n = s.length();
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(1) == '0' ? 0 : 1;
        for (int i = 2; i <= n; i++) {
            int digit1 = Integer.valueOf(s.substring(i - 1, i));
            int digit2 = Integer.valueOf(s.substring(i - 2, i));
            if (digit1 >= 1) {
                dp[i] += dp[i - 1];
            }
            if (digit2 >= 10 && digit2 <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

    //also best, space optimised
    public static int decodeUsingDP_better(String s) {
        int one = 1, two = 1;
        if (s.charAt(0) == '0') {
            return 0;
        }
        int current = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                current = one;
            }
            int value = Integer.parseInt(s.substring(i - 1, i + 1));
            if (value >= 10 && value <= 26) {
                current += two;
            }
            two = one;
            one = current;
        }
        return current;
    }


    public static int decodeUsingRecursionMemoization(String s) {
        int[] memo = new int[s.length()];
        return decodeHelper(s, 0, memo);
    }

    private static int decodeHelper(String s, int index, int[] memo) {
        // Base case: if we've processed the entire string, there's one way to decode it
        if (index == s.length()) {
            return 1;
        }
        // If the current character is '0', it cannot be decoded
        if (s.charAt(index) == '0') {
            return 0;
        }
        // If we've already calculated the result for this index, return it
        if (memo[index] != 0) {
            return memo[index];
        }

        int ways = decodeHelper(s, index + 1, memo);  // Decode one character


        if (index < s.length() - 1) {
            int twoDigit = Integer.parseInt(s.substring(index, index + 2));
            if (twoDigit >= 10 && twoDigit <= 26) {
                ways += decodeHelper(s, index + 2, memo);  // Decode two characters if valid
            }
        }

        // Store the result in the memo array
        memo[index] = ways;

        return ways;
    }


    //Using exponential T(c)
    static int decodeWaysRecursive(String s, int n) {
        if (n == 0) {
            return 1; //base case
        }
        int index = s.length() - n; // top-down approach
        if (s.charAt(index) == '0') {
            return 0; // Cannot decode a sequence starting with '0'
        }
        int ways = decodeWaysRecursive(s, n - 1);
        if (n >= 2) {
            int twoDigitWays = Integer.valueOf(s.substring(index, index + 2));
            if (twoDigitWays >= 10 && twoDigitWays <= 26) {
                ways += decodeWaysRecursive(s, n - 2);
            }
        }
        return ways;
    }

    //same as above
    static int decodeWaysRecursion_2(String s, int indexPosition) {
        if (indexPosition == s.length()) {
            return 1;
        }
        if (s.charAt(indexPosition) == '0') {
            return 0;
        }

        int ways = decodeWaysRecursion_2(s, indexPosition + 1);

        if (indexPosition + 1 < s.length()) {
            int TwoDigitWays = Integer.valueOf(s.substring(indexPosition, indexPosition + 2));
            if (TwoDigitWays >= 10 && TwoDigitWays <= 26) {
                ways += decodeWaysRecursion_2(s, indexPosition + 2);
            }
        }
        return ways;
    }
}
