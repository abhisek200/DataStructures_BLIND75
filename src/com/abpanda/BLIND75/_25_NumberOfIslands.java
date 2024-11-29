package com.abpanda.BLIND75;
/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.*/
/*
Input: grid = [
        ["1","1","0","0","0"],
        ["1","1","0","0","0"],
        ["0","0","1","0","0"],
        ["0","0","0","1","1"]
        ]
Output: 3*/

public class _25_NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        int numberOfIslands = numIslands(grid);
        System.out.println("Number of Islands : " + numberOfIslands);

    }

    public static int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int countIslands = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    countIslands++;
                    callBFS(grid, i, j);
                }
            }
        }
        return countIslands;
    }

    static void callBFS(char grid[][], int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0') {
            return;
        } else {
            grid[i][j] = '0';
            callBFS(grid, i + 1, j); //down
            callBFS(grid, i - 1, j); //up
            callBFS(grid, i, j - 1); //left
            callBFS(grid, i, j + 1); //right
        }

    }
}
