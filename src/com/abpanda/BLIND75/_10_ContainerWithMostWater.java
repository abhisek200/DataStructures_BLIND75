package com.abpanda.BLIND75;

public class _10_ContainerWithMostWater {
    public static void main(String[] args) {
        int max = 0;
        int arrHeight[] = {3, 2, 7, 4, 1, 3, 6, 2}; //24 o/p
        int maxArea = 0;
        int leftIndex = 0;
        int rightIndex = arrHeight.length - 1;

        while (leftIndex < rightIndex) {
            int width = rightIndex - leftIndex;
            int area = Math.min(arrHeight[leftIndex], arrHeight[rightIndex]) * width; // minimum height
            maxArea = Math.max(area, maxArea);
            if (arrHeight[leftIndex] > arrHeight[rightIndex]) {
                rightIndex--;
            } else {
                leftIndex++;
            }
        }
        System.out.println("Max Area : " + maxArea);
    }
}
