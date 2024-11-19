package com.abpanda.BLIND75;

public class _6_MaximumProductSubArray {
    public static void main(String[] args) {
        // Maximum product sub-array
        int arr[] = {5, 3, 1, -2, 0, -5, 8, -3}; //120
//        int arr[] = {5, 3, -3, 6, 7}; //42

        int current = arr[0];
        int maxValue = arr[0];
        int minValue = arr[0];
        int result = arr[0];
        for (int i = 0; i < arr.length; i++) {
            current = arr[i];
            int tempValue = Math.max(current, Math.max(current * minValue, current * maxValue)); //get max
            minValue = Math.min(current, Math.min(current * minValue, current * maxValue)); //get actual min
            maxValue = tempValue; // update actual max
            result = Math.max(result, maxValue); //compare
        }
        System.out.println("Maximum Sub-array product : " + result);
    }
}
