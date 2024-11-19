package com.abpanda.Recursion;

public class assignment7 {
    public static void main(String[] args) {
//        int arr[] = { 1, 2, 3, 4, 5 };
//        productofArray(arr, arr.length); #120

        int arr[] = {1, 2, 3, 4, 5};
        int product = productofArray(arr, arr.length);
        System.out.println("POA : " + product);
    }

    public static int productofArray(int arr[], int length) {
        if (length <= 0) {
            return 1;
        }
        return arr[length - 1] * productofArray(arr, length - 1);
    }
}
