package com.abpanda.OneDimensionalArrays;

import java.util.Arrays;

public class arraysInsertion {
    public static void main(String[] args) {
        int[] a = new int[3];
        a[0]=1;
        a[1]=2;
        a[2]=3;
        System.out.println(Arrays.toString(a));
        System.out.println(a); // print the object

        SingleDimensionalArray sda = new SingleDimensionalArray(3);
        sda.insert(0,99);
        sda.insert(1,22);
        sda.insert(2,28); //Successful
        sda.insert(12,128); //ArrayException
        sda.insert(1,18); //already present

        var arrOh = sda.arr[1];
        System.out.println("2nd Element : "+arrOh);

        System.out.println("Array Traversal");
        sda.traversalArray();
        System.out.println("Search for an element in Array");

        System.out.println("Array Search");
        sda.searchInArray(99);
        sda.searchInArray(6969);

        System.out.println("Array Element Delete");
        sda.deleteElement(0);

        sda.traversalArray();
    }
}
