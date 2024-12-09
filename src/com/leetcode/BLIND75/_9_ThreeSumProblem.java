package com.leetcode.BLIND75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _9_ThreeSumProblem {
    public static void main(String[] args) {
        int nums[] = {-5, 0, -3, 5, 1, -5, 0, 2, 1};
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length && nums[i] < 0; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                TwoSum(nums, i, result);
            }
        }
        System.out.println("Getting the Set for 3SUM : " + result);
    }

    public static void TwoSum(int[] nums, int i, List<List<Integer>> result) {
        int left = i + 1;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[i] + nums[left] + nums[right];
            if (sum < 0) {
                left++;
            } else if (sum > 0) {
                right--;
            } else if (sum == 0) {
                //updating result set anyway
                result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                //updating left and right pointers for next iteration
                left++;
                right--;
                //skip duplicate for `nums[left` values
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
                // Skip duplicate `nums[right]` values
                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }
            }
        }
    }
}
