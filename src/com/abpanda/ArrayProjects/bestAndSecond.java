package com.abpanda.ArrayProjects;

import java.util.Arrays;
import java.util.Scanner;


//Best Score
// Given an array, write a function to get first, second best scores from the array and return it in new array.
// Array may contain duplicates.
// Example
//  myArray = {84,85,86,87,85,90,85,83,23,45,84,1,2,0}
//  firstSecond(myArray) ~{90, 87}
public class bestAndSecond {
    Scanner sc = new Scanner(System.in);
    int arr[];

    bestAndSecond(int length) {
        System.out.println("for length of " + length + ". \nEnter the array values:");
        arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Array : " + Arrays.toString(arr));
        System.out.println("Best Score and Second Best Score \n" + Arrays.toString(getBestAndSecond(arr)));
    }

    int[] getBestAndSecond(int arr[]) {
        int newarr[] = new int[2];
        int getTheBest = Integer.MIN_VALUE;
        int secondBest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > getTheBest) {
                secondBest = getTheBest;
                getTheBest = arr[i];
            } else if (arr[i] > secondBest && arr[i] < getTheBest) {
                secondBest = arr[i];
            }
        }
        newarr[0] = getTheBest;
        newarr[1] = secondBest;
        return newarr;
    }
}
