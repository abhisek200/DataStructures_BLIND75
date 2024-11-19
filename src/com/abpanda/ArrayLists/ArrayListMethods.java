package com.abpanda.ArrayLists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ArrayListMethods {
    public void exampleArraylist1() {
        ArrayList<Integer> numbers = new ArrayList<Integer>(Arrays.asList(12, 21, 33, 43, 67));
        //basically this is conversion of List to ArrayList

        //normal approach = numbers.add(21); ..etc
        System.out.println(numbers);
    }

    public void ArrayListInsert() {
        ArrayList<String> str = new ArrayList<String>();
        str.add("Abhisek");
        str.add("Foo");
        str.add("Bar");
        str.add("Hypnotise");
        str.add("run by the Screams outside");
        str.add(0, "Panda");
        str.add(0, "Abhijeet");
        System.out.println(str);
        System.out.println("using get(3) : " + str.get(3));
        System.out.println("using get(1) : " + str.get(1));
    }

    public void arrayTraverse() {
        ArrayList<String> str2 = new ArrayList<String>();
        str2.add("yes");
        str2.add("no");
        str2.add("and");
        str2.add("you");
        str2.add("outside");
        str2.add(0, "of heart");
        str2.add(0, "jar");
        //approach 2
        System.out.println("\n----Foreach Approach-----");
        for (String letter : str2) {
            System.out.print(letter + " , ");
        }

        //approach 3
        Iterator<String> iterator = str2.iterator();
        System.out.println("\n----Iterator Approach-----");
        while (iterator.hasNext()) {
            String letter = iterator.next();
            System.out.print(letter + " , ");
        }

        System.out.println("---SearchArrayList---");
        System.out.println("Array element search in str2");
        for (String letter : str2) {
            if (letter.equals("jar")) {
                System.out.println("element is found!");
            }
        }
        int index = str2.indexOf("heart");
        int index2 = str2.indexOf("yes");
        System.out.println("heart is found at index : " + index);
        System.out.println("yes is found at index : " + index2);

        System.out.println("---deleteElementArrayList---");
        System.out.println("str2 List : " + str2);
        str2.remove(1);
        System.out.println("str2 new : "+str2);

    }
}
