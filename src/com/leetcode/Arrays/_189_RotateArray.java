package com.leetcode.Arrays;

public class _189_RotateArray {

    public void rotate(int[] nums, int k) {
        // [ 1,2,3,4,5,6,7] k=3
        // logic
        //Reverse -> [7,6,5,4,3,2,1]
        //Reverse k elements and n-k elements -> [5,6,7,1,2,3,4]

        //reverse entire
        reverse(nums, 0, nums.length - 1);

        //reverse till k
        reverse(nums, 0, k - 1);

        //reverse n-k
        reverse(nums, k, nums.length - 1);

    }

    void reverse(int nums[], int start, int end) {
//        [7,6,5,4,3,2,1]
//        [5,6,7,4,3,2,1]
        int temp;
        while (start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        _189_RotateArray solution = new _189_RotateArray();

        int[] test1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        solution.rotate(test1, k1);
        System.out.println(java.util.Arrays.toString(test1));  // Expected output: [5, 6, 7, 1, 2, 3, 4]

        int[] test2 = {-1, -100, 3, 99};
        int k2 = 2;
        solution.rotate(test2, k2);
        System.out.println(java.util.Arrays.toString(test2));  // Expected output: [3, 99, -1, -100]
    }
}

