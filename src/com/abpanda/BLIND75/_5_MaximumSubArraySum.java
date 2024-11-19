package com.abpanda.BLIND75;

public class _5_MaximumSubArraySum {
    public static void main(String[] args) {
        int arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        /* o/p  = 7 */
        int currentMAXSUM = 0;
        int actualMAX=0;
        for (int i = 0; i< arr.length; i++) {
            if(currentMAXSUM <0){
                currentMAXSUM =0;
            } // because if you start with -ve number it will always result less
            currentMAXSUM = currentMAXSUM+arr[i];
            actualMAX = Math.max(currentMAXSUM, actualMAX);
        }
        System.out.println("Your maximum subarray sum is : "+actualMAX);
    }
}
