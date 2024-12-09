package com.leetcode.Strings;

import java.util.*;

public class _387_FirstUniqueCharacter {

    // Placeholder function to find the first unique character in a string
    public int firstUniqChar(String s) {
        // Logic to find the first unique character will be implemented here
        Hashtable<Character, Integer> mapMe = new Hashtable<>();

        for (int i = 0; i < s.length(); i++) {
            if (!mapMe.containsKey(s.charAt(i))) {
                mapMe.put(s.charAt(i), 1);
            } else {
                mapMe.put(s.charAt(i), mapMe.get(s.charAt(i)) + 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (mapMe.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        _387_FirstUniqueCharacter solution = new _387_FirstUniqueCharacter();

        // Test case 1
        String s1 = "leetcode";
        System.out.println("Test Case 1: " + solution.firstUniqChar(s1)); // Expected output: 0

        // Test case 2
        String s2 = "loveleetcode";
        System.out.println("Test Case 2: " + solution.firstUniqChar(s2)); // Expected output: 2

        // Test case 3
        String s3 = "aabb";
        System.out.println("Test Case 3: " + solution.firstUniqChar(s3)); // Expected output: -1

        // Additional Test case 4
        String s4 = "abcabcde";
        System.out.println("Test Case 4: " + solution.firstUniqChar(s4)); // Expected output: 6

        // Additional Test case 5
        String s5 = "z";
        System.out.println("Test Case 5: " + solution.firstUniqChar(s5)); // Expected output: 0
    }
}
