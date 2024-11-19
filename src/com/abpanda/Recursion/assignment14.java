package com.abpanda.Recursion;

public class assignment14 {

//    Implement a function that capitalizes each word in String.
//
//            Example
//
//    input: i love java
//    output : I Love Java

    public static void main(String[] args) {
        String input = "i love java";
        String result = capitalizeWords(input);
        System.out.println("Output: " + result); // Expected output: I Love Java
    }

    public static String capitalizeWords(String str) {
        return capitalizeHelper(str.split(" "), 0);
    }

    private static String capitalizeHelper(String[] words, int index) {
        // Base case: if the index reaches the end of the array, return an empty string
        if (index >= words.length) {
            return "";
        }

        // Capitalize the first letter of the current word if it's not empty
        String capitalizedWord = words[index].isEmpty()
                ? ""
                : words[index].substring(0, 1).toUpperCase() + words[index].substring(1);

        // Recursive case: capitalize the rest and join with a space
        return capitalizedWord + (index < words.length - 1 ? " " : "") + capitalizeHelper(words, index + 1);
    }
}
