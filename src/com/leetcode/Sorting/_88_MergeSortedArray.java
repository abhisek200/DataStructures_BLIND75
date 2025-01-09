package com.leetcode.Sorting;

import java.util.Arrays;

public class _88_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums1Pointer = m - 1;
        int nums2Pointer = n - 1;
        int lastIndex = nums1.length - 1;

        while (nums2Pointer >= 0) {
            if (nums1Pointer >= 0 && nums1[nums1Pointer] > nums2[nums2Pointer]) {
                nums1[lastIndex] = nums1[nums1Pointer];
                nums1Pointer--;
                lastIndex--;
            } else {
                nums1[lastIndex] = nums2[nums2Pointer];
                nums2Pointer--;
                lastIndex--;
            }
        }
    }

    public static void main(String[] args) {
        _88_MergeSortedArray solution = new _88_MergeSortedArray();

        // Example 1
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        solution.merge(nums1, m, nums2, n);
        System.out.println("Merged Array: " + Arrays.toString(nums1));
        // Expected: [1, 2, 2, 3, 5, 6]

        // Example 2
        int[] nums1Example2 = {1};
        int m2 = 1;
        int[] nums2Example2 = {};
        int n2 = 0;
        solution.merge(nums1Example2, m2, nums2Example2, n2);
        System.out.println("Merged Array: " + Arrays.toString(nums1Example2));
        // Expected: [1]

        // Example 3
        int[] nums1Example3 = {0};
        int m3 = 0;
        int[] nums2Example3 = {1};
        int n3 = 1;
        solution.merge(nums1Example3, m3, nums2Example3, n3);
        System.out.println("Merged Array: " + Arrays.toString(nums1Example3));
        // Expected: [1]
    }
}
