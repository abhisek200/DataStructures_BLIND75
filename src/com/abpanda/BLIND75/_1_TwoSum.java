package com.abpanda.BLIND75;

import java.util.HashMap;
import java.util.Map;

public class _1_TwoSum {
    public static void main(String[] args) {
        //using hashmap
        //[1,8,15,2,5]
        Map<Integer, Integer> hashmap = new HashMap<>();
        int arr[] = {1, 8, 15, 2, 5};
        int target = 13;
        for (int i = 0; i < arr.length; i++) {
            int temp = target - arr[i];
            if (!hashmap.containsKey(temp)) {
                hashmap.put(arr[i], i);
            } else {
                System.out.println("Found values at index : " + i + " " + hashmap.get(temp));
            }
        }
    }
}
