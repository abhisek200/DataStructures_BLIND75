package com.leetcode.Strings;

import java.util.*;

public class _242_ValidAnagram {

    // Placeholder function to check if two strings are anagrams
    public boolean isAnagram(String s, String t) {
        // Logic to check for anagrams will be implemented here
        HashMap<Character, Integer> hasMe = new HashMap<>();
        for (Character ch : s.toCharArray()) {
            if (hasMe.containsKey(ch)) {
                hasMe.put(ch, hasMe.get(ch) + 1);
            } else {
                hasMe.put(ch, 1);
            }
        }

        for (Character ch : t.toCharArray())
            if (hasMe.containsKey(ch)) {
                hasMe.put(ch, hasMe.get(ch) - 1);
                if (hasMe.get(ch) == 0) {
                    hasMe.remove(ch);
                }
            } else {
                return false;
            }
        return hasMe.isEmpty();
    }

    public static void main(String[] args) {
        _242_ValidAnagram solution = new _242_ValidAnagram();

        // Test case 1
        String s1 = "anagram";
        String t1 = "nagaram";
        System.out.println("Test Case 1: " + solution.isAnagram(s1, t1)); // Expected output: true

        // Test case 2
        String s2 = "rat";
        String t2 = "car";
        System.out.println("Test Case 2: " + solution.isAnagram(s2, t2)); // Expected output: false

        // Test case 3
        String s3 = "aabbcc";
        String t3 = "ccbbaa";
        System.out.println("Test Case 3: " + solution.isAnagram(s3, t3)); // Expected output: true

        // Additional Test case 4
        String s4 = "abcd";
        String t4 = "dcbae";
        System.out.println("Test Case 4: " + solution.isAnagram(s4, t4)); // Expected output: false

        // Additional Test case 5
        String s5 = "a";
        String t5 = "a";
        System.out.println("Test Case 5: " + solution.isAnagram(s5, t5)); // Expected output: true
    }
}
