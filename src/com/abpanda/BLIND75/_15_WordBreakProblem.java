package com.abpanda.BLIND75;

import java.util.List;
/*    Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a
      space-separated sequence of one or more dictionary words.
      Note that the same word in the dictionary may be reused multiple times in the segmentation.*/

//    Input: s = "leetcode", wordDict = ["leet","code"]
//    Output: true
//    Explanation: Return true because "leetcode" can be segmented as "leet code".
public class _15_WordBreakProblem {
    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = List.of("cats", "dog", "sand", "and", "cat");

        boolean result = wordBreakRecusrion(s, wordDict);
        System.out.println("Using recursion : " + result);

        //using DP Array[] O(n^2 x m) m-> lookup to dictionary
        boolean resultDPArray = usingDPApproach(s, wordDict);
        System.out.println("Using DP Approach : " + resultDPArray);
    }

    public static boolean usingDPApproach(String s, List<String> dictionary) {
        boolean dp[] = new boolean[s.length() + 1];
        dp[0] = true; //base case
        for (int i = 1; i <= s.length(); i++) {
//            for (int j = i - 1; j > 0; j--) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dictionary.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static boolean wordBreakRecusrion(String s, List<String> dict) {
        // Base case: if the string is empty, return true
        if (s.length() == 0) {
            return true;
        }

        // Try all prefixes of the string
        for (int i = 0; i < s.length(); i++) {
            String left = s.substring(0, i + 1);

            // If the prefix is in the dictionary and the rest of the string can also be segmented
            if (dict.contains(left) && wordBreakRecusrion(s.substring(i + 1), dict)) {
                return true;
            }
        }

        return false; // No valid segmentation found
    }
}
