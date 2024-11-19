package com.abpanda.ArrayProjects;

import java.util.Arrays;
import java.util.Scanner;


//Middle Function
// Write a function called middle that takes an array and returns a new array that contains all but the first and last elements.
//
// myArray = [1, 2, 3, 4]
// middle(myArray)  # [2,3].
public class middleFunction {
    int arr[];
    Scanner sc = new Scanner(System.in);

    middleFunction(int lengthOfArray) {
        arr = new int[lengthOfArray];
        System.out.println("enter for " + lengthOfArray + " values in the array");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(" Array : " + Arrays.toString(arr));
        System.out.println(" Middle Function Array : " + Arrays.toString(getMiddlefunction(arr)));
    }

    public int[] getMiddlefunction(int arr[]) {
        int newArray[] = new int[arr.length-2];
        for (int i = 0,select=0; i < arr.length; i++) {
            if (!(i == 0 || i == arr.length - 1)) {
                newArray[select] = arr[i];
                select++;
            }
        }
        return newArray;
    }
}
