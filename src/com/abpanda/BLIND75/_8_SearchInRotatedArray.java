package com.abpanda.BLIND75;

public class _8_SearchInRotatedArray {
    public static void main(String[] args) {
        int arr[] = {4, 5, 6, 7, 0, 1, 2};
        int target = 5;

        int leftIndex = 0, rightIndex = arr.length - 1, mid;
        int returnIndex = 0;

        while (leftIndex <= rightIndex) {
            mid = (leftIndex + rightIndex) / 2;
            if (target == arr[mid]) {
                System.out.println("return index : " + mid);
                break;
            }
            if (arr[leftIndex] <= arr[mid]) {
                if (target >= arr[leftIndex] && target < arr[mid]) {
                    rightIndex = mid - 1;
                } else {
                    leftIndex = mid + 1;
                }
            } else {
                //arr[leftIndex] > arr[mid]
                if (target > arr[mid] && target <= arr[rightIndex]) {
                    leftIndex = mid + 1;
                } else {
                    rightIndex = mid - 1;
                }
            }
        }
    }
}

