package com.abpanda.TwoDimensionalArrays;

import java.util.Arrays;

public class TwoDimensionalArray {
    int arr[][] = null;

    public TwoDimensionalArray(int numberOfRows, int numberOfColumns) {
        this.arr = new int[numberOfRows][numberOfColumns];
        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr[0].length; column++) {
                arr[row][column] = Integer.MIN_VALUE;
            }
        }
    }

    public void arrayExampleCode() {
        int ex[][]; //declare
        ex = new int[3][3]; //intialise
        ex[0][0] = 1;
        ex[0][1] = 2;
        ex[0][2] = 3;
        ex[1][0] = 4;
        ex[1][1] = 5;
        ex[1][2] = 6;
        ex[2][0] = 7;
        ex[2][1] = 8;
        ex[2][2] = 9;
        System.out.println(Arrays.deepToString(ex));
        //deepToString is used in 2d arrays to display
    }

    public void insertValueInArray(int row, int col, int value) {
        try {
            if (arr[row][col] == Integer.MIN_VALUE) {
                arr[row][col] = value;
                System.out.println("Value is successfully inserted !");
            } else {
                System.out.println("Already a value is inserted!");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid Index to the array ! Out Of Bounds !");
        }
    }

    public void accessingIndex(int row, int column) {
        System.out.println("\nAccessing Row#" + row + " Col#" + column);
        try {
            System.out.println("Value is " + arr[row][column]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid Index to the array ! Out Of Bounds !");
        }
    }

    public void traversingArray() {
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[0].length; col++) {
                System.out.print(arr[row][col] + " ");
            }
            System.out.println();
        }
    }

    public void searchValue(int searchValue) {
        System.out.println("\nValue: " + searchValue);
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[0].length; col++) {
                if (arr[row][col] == searchValue) {
                    System.out.println(+searchValue + " is found at Row: " + row + " Columm" + col);
                    return;
                }
            }
        }
        System.out.println("given value not found -_-");
    }

    public void deleteIndex(int row, int col) {
        try {
            System.out.println("\nSuccessfully deleted value : " + arr[row][col]);
            arr[row][col]=Integer.MIN_VALUE;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index provided.");
        }
    }


}
