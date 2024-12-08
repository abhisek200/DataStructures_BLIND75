package com.leetcode.Arrays;

import java.util.HashSet;

public class _36_ValidSudoku {

    /**
     * Validates whether a given 9x9 Sudoku board is valid.
     *
     * @param board 2D character array representing the Sudoku board
     * @return true if the board is valid, false otherwise
     * <p>
     * the box/row/col should be unique nos!
     */
    public boolean isValidSudoku(char[][] board) {
        // TODO: Implement the logic to validate the Sudoku board

        HashSet<String> myHash = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    if (!myHash.add(i + " row " + board[i][j])) { // 0 row 5
                        return false;
                    }
                    if (!myHash.add(j + " col " + board[i][j])) { // 0 col 5
                        return false;
                    }
                    int getBoxNumber = ((i / 3) * 3) + (j / 3);
                    if (!myHash.add(getBoxNumber + " box " + board[i][j])) { // 0 box 5
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        _36_ValidSudoku validator = new _36_ValidSudoku();

        // Test case 1: Valid Sudoku board
        char[][] testCase1 = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println("Test Case 1: " + validator.isValidSudoku(testCase1)); // Expected: true

        // Test case 2: Invalid due to duplicate in a row
        char[][] testCase2 = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'5', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println("Test Case 2: " + validator.isValidSudoku(testCase2)); // Expected: false

        // Test case 3: Invalid due to duplicate in a column
        char[][] testCase3 = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '6', '8', '.', '.', '7', '9'}
        };
        System.out.println("Test Case 3: " + validator.isValidSudoku(testCase3)); // Expected: true
    }
}
