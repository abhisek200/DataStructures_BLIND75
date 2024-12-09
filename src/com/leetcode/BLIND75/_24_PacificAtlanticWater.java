package com.leetcode.BLIND75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    int directions[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        int heights[][] = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        int rowMax = matrix.length;
        int colMax = matrix[0].length;

        List<List<Integer>> resultList = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return resultList;
        }
        boolean[][] pacific = new boolean[rowMax][colMax];
        boolean[][] atlantic = new boolean[rowMax][colMax];
        //DFS
        for (int i = 0; i < colMax; i++) {
            dfs(matrix, 0, i, Integer.MIN_VALUE, pacific);
            dfs(matrix, rowMax - 1, i, Integer.MIN_VALUE, atlantic);
        }
        for (int i = 0; i < rowMax; i++) {
            dfs(matrix, i, 0, Integer.MIN_VALUE, pacific);
            dfs(matrix, i, colMax - 1, Integer.MIN_VALUE, atlantic);
        }

        //preparing the result
        for (int i = 0; i < rowMax; i++) {
            for (int j = 0; j < colMax; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    resultList.add(Arrays.asList(i, j));
                }
            }
        }
        return resultList;
    }

    public void dfs(int[][] matrix, int i, int j, int prev, boolean[][] ocean) {
        if (i < 0 || i >= ocean.length || j < 0 || j >= ocean[0].length) {
            return;  //edge case
        }
        if (matrix[i][j] < prev || ocean[i][j] == true) return;
        ocean[i][j] = true;
        for (int[] dir : directions) {
            dfs(matrix, i + dir[0], j + dir[1], matrix[i][j], ocean);
        }
    }
}

public class _24_PacificAtlanticWater {
    public static void main(String[] args) {
        int heights[][] = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        Solution sol = new Solution();
        System.out.println(sol.pacificAtlantic(heights));
    }
}


