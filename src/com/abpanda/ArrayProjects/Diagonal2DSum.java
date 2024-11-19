package com.abpanda.ArrayProjects;

//2D Arrays
// Given 2D array calculate the sum of diagonal elements.
// Example
//  myArray2D= {{1,2,3},{4,5,6},{7,8,9}};
//  sumDiagonalElements(myArray2D) # 15 [1+5+9]
public class Diagonal2DSum {
    int sum = 0;

    Diagonal2DSum(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i][i];
        }
        System.out.println("Sum of Diagonal : " + sum);

    }


}
