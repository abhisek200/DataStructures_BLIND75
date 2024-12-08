package com.leetcode.Arrays;

import java.util.*;

public class _49_ValidAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> hashMe = new HashMap<>();
        for (String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String sorted = new String(ch);

            if (!hashMe.containsKey(sorted)) {
                hashMe.put(sorted, new ArrayList<>());
            }
            hashMe.get(sorted).add(s);
        }
        return new ArrayList<>(hashMe.values());
    }

    public static void main(String[] args) {
        _49_ValidAnagrams solution = new _49_ValidAnagrams();

        // Test case 1
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("Test Case 1: " + solution.groupAnagrams(strs1));

        // Test case 2
        String[] strs2 = {""};
        System.out.println("Test Case 2: " + solution.groupAnagrams(strs2));

        // Test case 3
        String[] strs3 = {"a"};
        System.out.println("Test Case 3: " + solution.groupAnagrams(strs3));

        // Additional Test case 4
        String[] strs4 = {"abc", "cba", "bca", "abcd", "bcda", "dacb"};
        System.out.println("Test Case 4: " + solution.groupAnagrams(strs4));
    }
}
