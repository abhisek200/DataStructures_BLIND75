package com.abpanda.Recursion;

public class assignment11 {
    public static void main(String[] args) {
        System.out.println("Reversed 'java': " + reverse("java"));           // Expected output: 'avaj'
        System.out.println("Reversed 'appmillers': " + reverse("appmillers")); // Expected output: 'srellimppa'
    }

    public static String reverse(String str) {
        // Base case: if the string is empty or has one character, it's already "reversed"
        if (str.isEmpty()) {
            return str;
        }
        // Recursive case: take the last character and add it to the reverse of the rest of the string
        return str.charAt(str.length() - 1) + reverse(str.substring(0, str.length() - 1));
    }
}
