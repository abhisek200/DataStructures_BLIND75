package com.leetcode.BLIND75;

/*
You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
Return true if you can reach the last index, or false otherwise.
        Example 1:
Input: nums = [2,3,1,1,4]
Output: True
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
*/

public class _21_JumpGame {
    public static void main(String[] args) {
        int arr[] = {5, 4, 3, 2, 1, 1, 7};
        System.out.println("Can this Array Jump ? : " + canJump(arr));
    }

    static boolean canJump(int arr[]) {
        int length = arr.length;
        int maxIndexValue = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (i > maxIndexValue) {
                return false;
            }
            if (maxIndexValue >= arr.length - 1) {
                return true;
            }
            maxIndexValue = Math.max(i + arr[i], maxIndexValue);
        }
        return true;
    }
}
