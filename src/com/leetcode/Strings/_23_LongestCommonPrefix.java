package com.leetcode.Strings;

public class _23_LongestCommonPrefix {

    // Placeholder method to find the longest common prefix
    public static String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            String temp = "";
            int sizeMin = Math.min(prefix.length(), strs[i].length());

            for (int j = 0; j < sizeMin; j++) {
                if (prefix.charAt(j) == strs[i].charAt(j)) {
                    temp = temp + prefix.charAt(j);
                } else {
                    break;
                }
            }
            prefix = temp;
        }
        return prefix;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println("Test Case 1: " + longestCommonPrefix(new String[]{"flower", "flow", "flight"})); // Expected: "fl"
        System.out.println("Test Case 2: " + longestCommonPrefix(new String[]{"dog", "racecar", "car"}));    // Expected: ""
        System.out.println("Test Case 3: " + longestCommonPrefix(new String[]{"dog", "doggy", "dove"}));     // Expected: "do"
        System.out.println("Test Case 4: " + longestCommonPrefix(new String[]{"apple", "app", "apricot"}));   // Expected: "ap"
        System.out.println("Test Case 5: " + longestCommonPrefix(new String[]{""}));                        // Expected: ""
        System.out.println("Test Case 6: " + longestCommonPrefix(new String[]{"", "flow", "flame"}));        // Expected: ""
    }
}
