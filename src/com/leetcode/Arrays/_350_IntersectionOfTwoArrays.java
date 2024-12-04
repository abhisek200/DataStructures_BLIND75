package com.leetcode.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class _350_IntersectionOfTwoArrays {

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> frequencyContainer = new HashMap<Integer, Integer>();
        ArrayList<Integer> finalList = new ArrayList<>();
        //create hash map
        for (int i = 0; i < nums1.length; i++) {
            if (frequencyContainer.containsKey(nums1[i])) {
                frequencyContainer.put(nums1[i], frequencyContainer.get(nums1[i]) + 1);
            } else {
                frequencyContainer.put(nums1[i], 1);
            }
        }

        //check and add to array List
        for (int i = 0; i < nums2.length; i++) {
            if (frequencyContainer.containsKey(nums2[i])) {
                finalList.add(nums2[i]);
                frequencyContainer.put(nums2[i], frequencyContainer.get(nums2[i]) - 1);
                if (frequencyContainer.get(nums2[i]) == 0) {
                    frequencyContainer.remove(nums2[i]);
                }
            }
        }

        int[] res = new int[finalList.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = finalList.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        _350_IntersectionOfTwoArrays solution = new _350_IntersectionOfTwoArrays();

        int[] test1_nums1 = {1, 2, 2, 1};
        int[] test1_nums2 = {2, 2};
        System.out.println(Arrays.toString(solution.intersect(test1_nums1, test1_nums2)));  // Expected output: [2, 2]

        int[] test2_nums1 = {4, 9, 5};
        int[] test2_nums2 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(solution.intersect(test2_nums1, test2_nums2)));  // Expected output: [4, 9]
    }
}
