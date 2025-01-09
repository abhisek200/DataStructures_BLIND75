package com.leetcode.ObjectImplementation;

/* Created by abpanda on 08-01-2025 */

import java.util.Arrays;
import java.util.Random;

public class _384_ShuffleArray {
    private int[] nums;      // Stores the array passed in the constructor
    private int[] original;  // Stores the original configuration of the array

    public _384_ShuffleArray(int[] nums) {
        this.nums = nums;
    }

    public static void main(String[] args) {
        // Test cases
        int[] nums = {1, 2, 3};
        _384_ShuffleArray solution = new _384_ShuffleArray(nums);

        // Test shuffle
        System.out.println("Shuffled Array: " + Arrays.toString(solution.shuffle()));

        // Test reset
        System.out.println("Reset Array: " + Arrays.toString(solution.reset()));

        // Test shuffle again
        System.out.println("Shuffled Array Again: " + Arrays.toString(solution.shuffle()));
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        int shuffled[] = nums.clone();
        // nums [1,2,3]
        // shuffled [3,1,2]

        Random rand = new Random();
        for (int i = 0; i < shuffled.length; i++) {
            int randomNumber = rand.nextInt(shuffled.length); // get a random number
            int temp = shuffled[randomNumber];
            shuffled[randomNumber] = shuffled[i];  //swap with the random number index
            shuffled[i] = temp;
        }
        return shuffled;
    }
}

