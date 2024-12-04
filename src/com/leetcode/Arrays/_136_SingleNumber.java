package com.leetcode.Arrays;

public class _136_SingleNumber {

    public int singleNumber(int[] nums) {
//      Logic : Do XOR , at the end you will get the unique number -? as 1 ^ 1 = 0 -> this makes to store only unique number
        int xorMe = 0;
        for (int i = 0; i < nums.length; i++) {
            xorMe = xorMe ^ nums[i];
        }
        return xorMe;  // Placeholder return value
    }

    public static void main(String[] args) {
        _136_SingleNumber solution = new _136_SingleNumber();

        int[] test1 = {2, 2, 1};
        System.out.println(solution.singleNumber(test1));  // Expected output: 1

        int[] test2 = {4, 1, 2, 1, 2};
        System.out.println(solution.singleNumber(test2));  // Expected output: 4

        int[] test3 = {1};
        System.out.println(solution.singleNumber(test3));  // Expected output: 1
    }
}
