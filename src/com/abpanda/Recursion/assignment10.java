package com.abpanda.Recursion;

public class assignment10 {

    //idk
    //Callback Function
    public static void main(String[] args) {
        // Example callback function that checks if a number is odd
        System.out.println("Result of someRecursive({1,2,3,4}, isOdd): " + someRecursive(new int[]{1, 2, 3, 4}, assignment10::isOdd));  // Expected output: true
        System.out.println("Result of someRecursive({4,6,8,9}, isOdd): " + someRecursive(new int[]{4, 6, 8, 9}, assignment10::isOdd));  // Expected output: true
        System.out.println("Result of someRecursive({4,6,8}, isOdd): " + someRecursive(new int[]{4, 6, 8}, assignment10::isOdd));  // Expected output: false
    }

    // Callback function to check if a number is odd
    public static boolean isOdd(int n) {
        return n % 2 != 0;
    }
    public static boolean someRecursive(int[] arr, java.util.function.IntPredicate callback) {
        // Base case: if the array is empty, return false
        if (arr.length == 0) {
            return false;
        }

        // If the first element satisfies the callback, return true
        if (callback.test(arr[0])) {
            return true;
        }

        // Recursively check the rest of the array
        int[] rest = new int[arr.length - 1];
        System.arraycopy(arr, 1, rest, 0, arr.length - 1);
        return someRecursive(rest, callback);
    }
}
