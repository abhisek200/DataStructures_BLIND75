package com.abpanda.ArrayProjects;

import java.util.Arrays;

public class missingNumber {

    missingNumber(int arr[]) {
        System.out.println("For given Array : " + Arrays.toString(arr));
        if(!(getMissingNumber(arr)==0))
        System.out.println("Missing Number is : " + getMissingNumber(arr));
        else{
            System.out.println("It's Alright!! No number missing in sequence.");
        }
    }

    public int getMissingNumber(int arr[]) {
        int sum = ((arr.length+1) * ((arr.length+1) + 1)) / 2;
        int newSum = 0;
        for (int i = 0; i < arr.length; i++) {
            newSum = newSum + arr[i];
        }
        if(newSum!=sum) {
            int missingNumber = sum - newSum;
            return missingNumber;
        }
        else return 0;
    }
}
