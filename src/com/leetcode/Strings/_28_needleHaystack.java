package com.leetcode.Strings;

public class _28_needleHaystack {

    public static int strStr(String haystack, String needle) {


        //need to return the first match index
        //testmepickshit
        //pick

        if (needle.isEmpty()) {
            return 0;
        }

        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                for (int j = 0; j < needle.length(); j++) {
                    if (needle.charAt(j) != haystack.charAt(i + j)) {
                        break;
                    }
                    if (j == needle.length() - 1) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println("Test Case 1: " + strStr("sadbutsad", "sad")); // Expected: 0
        System.out.println("Test Case 2: " + strStr("leetcode", "leeto")); // Expected: -1
        System.out.println("Test Case 3: " + strStr("hello", "ll"));        // Expected: 2
        System.out.println("Test Case 4: " + strStr("aaa", "aaaa"));        // Expected: -1
        System.out.println("Test Case 5: " + strStr("", ""));               // Expected: 0
        System.out.println("Test Case 6: " + strStr("abcabc", "bc"));      // Expected: 1
    }
}
