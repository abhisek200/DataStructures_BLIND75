package com.leetcode.BLIND75;

import java.util.HashMap;
import java.util.Map;

public class _3_ContainsDuplicate {
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 1};
        boolean flag = false;
        Map<Integer, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashmap.containsKey(nums[i])) {
                flag = true;
                System.out.println("Contains Duplicate hence returning True!");
                break;
            } else {
                hashmap.put(nums[i], i);
            }
        }
        if (flag == false) {
            System.out.println("no duplicates, returning false.");
        }
    }

    //using hashset
//    int nums[] = {1, 2, 3, 1};
//    Set<Integer> hashset = new HashSet<>();
//        for (int num : nums) {
//        if (!hashset.add(num)) {
//            System.out.println("Contains Duplicate hence returning True!");
//            return;
//        }
//    }

}
