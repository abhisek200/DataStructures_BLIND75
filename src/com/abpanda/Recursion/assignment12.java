package com.abpanda.Recursion;

public class assignment12 {
//    isPalindrome('awesome') # false
//    isPalindrome('foobar') # false
//    isPalindrome('tacocat') # true
//    isPalindrome('amanaplanacanalpanama') # true
//    isPalindrome('amanaplanacanalpandemonium') # false

    public static void main(String[] args) {
        String a = "tacocat";
        boolean checkPalindrome = isPalindrome(a);
        System.out.println("isPal : " + checkPalindrome);
    }

    static boolean isPalindrome(String a) {
        if (a.length() <= 1) {
            return true;
        }
        if (a.charAt(0) != a.charAt(a.length() - 1)) return false;
        return isPalindrome(a.substring(1, a.length() - 1));
    }
}
