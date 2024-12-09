package com.leetcode.Strings;

import java.util.HashSet;

public class _3_LongestSubstring {

    // Placeholder method to find the length of the longest substring without repeating characters
    public static int lengthOfLongestSubstring(String s) {
        // Placeholder for your logic implementation

        //abcabcbb
        //abc -> bca -> cab
        int startIndex = 0;
        int maxLength = 0;
        HashSet<Character> hasMe = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (!hasMe.add(s.charAt(i))) {
                hasMe.remove(s.charAt(startIndex));
                startIndex++;
            } else {
                hasMe.add(s.charAt(i));
//                maxLength = Math.max(maxLength, (i - startIndex) + 1);
                maxLength = Math.max(maxLength, hasMe.size());
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        // Test cases
//        System.out.println("Test Case 1: " + lengthOfLongestSubstring("abcabcbb"));  // Expected: 3
//        System.out.println("Test Case 2: " + lengthOfLongestSubstring("bbbbb"));     // Expected: 1
//        System.out.println("Test Case 3: " + lengthOfLongestSubstring("pwwkew"));    // Expected: 3
//        System.out.println("Test Case 4: " + lengthOfLongestSubstring("abcde"));     // Expected: 5
//        System.out.println("Test Case 5: " + lengthOfLongestSubstring(""));         // Expected: 0
        System.out.println("Test Case 6: " + lengthOfLongestSubstring("dvdf"));     // Expected: 3
    }
}
