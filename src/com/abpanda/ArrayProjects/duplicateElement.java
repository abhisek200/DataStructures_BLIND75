package com.abpanda.ArrayProjects;

import java.util.Arrays;

public class duplicateElement {

    duplicateElement(int arr[]) {
        System.out.println("For given Array : " + Arrays.toString(arr));
        System.out.println("Reformed Array : " + Arrays.toString(deDuplicate(arr)));
    }

    int[] deDuplicate(int a[]) {

        int newSizing = 0;
        int reformedArray[] = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            boolean isDuplicateFlag = false;
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] == a[j]) {
                    isDuplicateFlag = true;
                    break;
                }
            }
            if (!(isDuplicateFlag)) {
                reformedArray[newSizing] = a[i];
                newSizing++;
            }
        }
        return (Arrays.copyOf(reformedArray, newSizing));
    }
}
