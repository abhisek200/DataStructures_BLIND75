package com.leetcode.Arrays;

import java.util.HashSet;

public class _217_ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashSet.contains(nums[i])) {
                return true;
            }
            hashSet.add(nums[i]);
        }
        return false;  // Placeholder return value
    }

    public static void main(String[] args) {
        _217_ContainsDuplicate solution = new _217_ContainsDuplicate();

        int[] test1 = {1, 2, 3, 1};
        System.out.println(solution.containsDuplicate(test1));  // Expected output: true

        int[] test2 = {1, 2, 3, 4};
        System.out.println(solution.containsDuplicate(test2));  // Expected output: false

        int[] test3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(solution.containsDuplicate(test3));  // Expected output: true
    }
}
