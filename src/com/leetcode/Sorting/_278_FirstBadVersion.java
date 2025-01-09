package com.leetcode.Sorting;

public class _278_FirstBadVersion {
    // Mock API: isBadVersion
    // This is just a placeholder. The actual API will be provided by the system.
    boolean isBadVersion(int version) {
        // Placeholder for API
        return true;
    }

    public int firstBadVersion(int n) {
        // Placeholder for binary search logic
        //main logic

        return -1; // Placeholder return value
    }

    public static void main(String[] args) {
        _278_FirstBadVersion solution = new _278_FirstBadVersion();

        // Example 1
        int n1 = 5;
        int bad1 = 4; // The API will be preconfigured to return true for versions >= bad1
        System.out.println("First Bad Version: " + solution.firstBadVersion(n1));
        // Expected: 4

        // Example 2
        int n2 = 1;
        int bad2 = 1; // The API will be preconfigured to return true for versions >= bad2
        System.out.println("First Bad Version: " + solution.firstBadVersion(n2));
        // Expected: 1
    }
}
