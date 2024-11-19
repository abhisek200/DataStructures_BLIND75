package com.abpanda.TwoDimensionalArrays;

public class ArrayMain {
    public static void main(String[] args) {
        TwoDimensionalArray twoD = new TwoDimensionalArray(2,2);

//        twoD.arrayExampleCode();
        // [a][b] -> a : row | b : column

        twoD.insertValueInArray(0,0,12);
        twoD.insertValueInArray(0,0,99); //Already a value present
        twoD.insertValueInArray(0,1,13);
        twoD.insertValueInArray(1,0,14);
        twoD.insertValueInArray(1,1,12);
        twoD.insertValueInArray(1,2,99); //ArrayIndexOutOfBound

        twoD.accessingIndex(1,1);
        twoD.accessingIndex(1,9); //ArrayIndexOutOfBound

        twoD.traversingArray();

        twoD.searchValue(12);
        twoD.searchValue(69); //Value not present

        twoD.deleteIndex(1,0);
        twoD.deleteIndex(1,8); //ArrayIndexOutOfBound





    }
}
