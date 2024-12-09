package com.leetcode.BLIND75;

import java.util.HashSet;

public class _26_LongestCommonSequence {
    public static void main(String[] args) {
//        int nArr[] = {100, 4, 200, 1, 2, 3};
        int nArr[] = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int longestSeq = longestConsecutive(nArr);
        System.out.println("Longest Consecutive Sequence : " + longestSeq);
    }

    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0; // Handle edge case of empty array
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int longestSequence = 1;
        int currentSequence = 1;
        int currentNum;

        for (int num : set) {
            if (set.contains(num - 1)) {
                continue;
            } else {
                currentNum = num;
                currentSequence = 1;
                while (set.contains(currentNum + 1)) {
                    currentSequence += 1;
                    currentNum++;
                }
                longestSequence = Math.max(longestSequence, currentSequence);
            }
        }
        return longestSequence;
    }
}
