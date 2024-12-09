package com.leetcode.BLIND75;

import java.util.Arrays;

public class _4_ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int arr[] = {4, 5, 1, 2, 3};
        //o/p : [30,24,,120,60,40]
        int prefix = 1, postfix = 1;
        int newarr[] = new int[arr.length];
        Arrays.fill(newarr, 1); //setting default as 1
        for (int i = 0; i < arr.length; i++) {
            newarr[i] = prefix;
            prefix = prefix * arr[i]; //for next
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            newarr[i] = postfix * newarr[i];
            postfix = postfix * arr[i];
        }
        System.out.println("your output : " + Arrays.toString(newarr));
    }
}
