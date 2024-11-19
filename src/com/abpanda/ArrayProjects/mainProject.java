package com.abpanda.ArrayProjects;

import java.util.Arrays;
import java.util.Scanner;

public class mainProject {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int p;
        System.out.print("Enter Project Number #");
        p = sc.nextInt();


        if (p != 0) {
            //        practice1
            if (p == 1) {
                daysAveragetemp diy = new daysAveragetemp();
            } else if (p == 2) {
                //    practice2
                middleFunction miy = new middleFunction(4);
            } else if (p == 3) {
                int a[][] = new int[3][3];
                a[0][0] = 12;
                a[0][1] = 13;
                a[0][2] = 14;
                a[1][0] = 15;
                a[1][1] = 16;
                a[1][2] = 17;
                a[2][0] = 18;
                a[2][1] = 19;
                a[2][2] = 20;
                System.out.println("Default Input, For the Array \n" + Arrays.deepToString(a));
                //    practice3
                Diagonal2DSum miy = new Diagonal2DSum(a);
            }
            else if (p == 4) {
                //    practice4
                bestAndSecond miy = new bestAndSecond(6);
            }
            else if (p == 5) {
                //    practice5
                int arr[]={1,2,4,5,6};
                missingNumber miy = new missingNumber (arr);
            }
            else if (p == 6) {
                //    practice6
                int arr2[]={1,2,2,4,4,2,5,6,9,0,43,4,5,6};
                duplicateElement diy = new duplicateElement (arr2);
            }
            else {
                System.out.println("Invalid #Bitch");
            }
        }
    }
}
