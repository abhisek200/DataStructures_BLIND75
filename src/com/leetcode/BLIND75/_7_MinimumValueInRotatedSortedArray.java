package com.leetcode.BLIND75;

public class _7_MinimumValueInRotatedSortedArray {
    public static void main(String[] args) {
        int arr[] = {5, 6, 7, 1, 2, 3, 4};
        int leftIndex = 0;
        int rightIndex = arr.length - 1;
        int midIndex = 0;
        int finalMin = arr[0];
        if (arr.length == 1) {
            System.out.println("Minimum value : " + finalMin);
        }
        while (leftIndex <= rightIndex) {
            if (arr[leftIndex] < arr[rightIndex]) {
                finalMin = Math.min(finalMin, arr[leftIndex]);
            }
            midIndex = (leftIndex + rightIndex) / 2;
            finalMin = Math.min(finalMin, arr[midIndex]);
            if (arr[leftIndex] <= arr[midIndex]) {
                leftIndex = midIndex + 1;
            } else {
                rightIndex = midIndex - 1;
            }
        }
        System.out.println("Minimum value : " + finalMin);
    }
}
