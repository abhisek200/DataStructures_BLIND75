package com.abpanda.ArrayProjects;

import java.util.Scanner;

/*
* Take Days Input and respective temperatures and calculate the average temp
* Find Number of Days above average temperature
* */
public class daysAveragetemp {
    int numberOfDays = 0;
    Scanner sc = new Scanner(System.in);

    daysAveragetemp() {
        try {
            System.out.println("Enter Number Of Days : ");
            this.numberOfDays = sc.nextInt();
            calculateAverageAndPrint(numberOfDays);
        } catch (Exception e) {
            System.out.println("Not An Integer");
        }
    }

    public void calculateAverageAndPrint(int n) {
        int days[] = new int[n];
        double temperature[] = new double[n];
        double sum = 0.0;
        double b;
        for (int i = 1; i <= numberOfDays; i++) {
            System.out.print("Enter Day " + i + " Temperature : ");
            b = sc.nextDouble();
            days[i - 1] = i;
            temperature[i - 1] = b;
            System.out.print(" " + b);
            System.out.println();
            sum = sum + b;
        }
        double averageTemp = sum / numberOfDays;
        System.out.println("Average : " + averageTemp);
        System.out.println(checkAboveAverage(days, temperature, averageTemp) + " day(s) above average temperature, Kudos!");
    }

    public int checkAboveAverage(int[] days, double[] temperature, double averageTemp) {
        int counter = 0;
        for (int i = 0; i < days.length; i++) {
            if (temperature[i] > averageTemp) {
                counter++;
            }
        }
        return counter;
    }
}

