package com.leetcode.Arrays;

public class _48_RotateImage {

    /**
     * Rotates the given n x n 2D matrix by 90 degrees clockwise in-place.
     *
     * @param matrix 2D integer array representing the image
     */
    public void rotate(int[][] matrix) {
        // TODO: Implement the logic to rotate the matrix

        //1st transpose
        //then reverse

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //reversing the transposed matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[0].length - j - 1];
                matrix[i][matrix[0].length - j - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        _48_RotateImage rotator = new _48_RotateImage();

        // Test case 1: 3x3 matrix
        int[][] testCase1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotator.rotate(testCase1);
        System.out.println("Test Case 1: ");
        printMatrix(testCase1);

        // Test case 2: 4x4 matrix
        int[][] testCase2 = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        rotator.rotate(testCase2);
        System.out.println("Test Case 2: ");
        printMatrix(testCase2);
    }

    /**
     * Utility function to print the matrix in a readable format.
     *
     * @param matrix 2D integer array to print
     */
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
