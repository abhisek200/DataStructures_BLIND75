package com.abpanda.BLIND75;

import java.util.ArrayList;
import java.util.List;

public class _16_CombinationSum {
    public static void main(String[] args) {

        int candidate[] = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> result = combinationSum(candidate, target);
        System.out.println("Combinations: " + result);
    }

    // Main function to find all combinations
    public static List<List<Integer>> combinationSum(int[] candidate, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        backtrack(candidate, target, 0, combination, result);
        return result;
    }

    // Backtracking helper function
    private static void backtrack(int[] candidate, int target, int start, List<Integer> combination, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(combination)); // Add the valid combination
            return;
        }
        if (target < 0) {
            return; // Backtrack if the target is negative
        }

        // Explore each number starting from the combination index
        for (int i = start; i < candidate.length; i++) {
            combination.add(candidate[i]); // Add combination number to the combination
            backtrack(candidate, target - candidate[i], i, combination, result); // Recur with the same index for repeated use of numbers
            combination.remove(combination.size() - 1); // Backtrack by removing the last number
        }
    }
}
