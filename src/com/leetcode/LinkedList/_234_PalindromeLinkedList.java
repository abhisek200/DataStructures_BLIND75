package com.leetcode.LinkedList;

public class _234_PalindromeLinkedList {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // Function to check if the linked list is a palindrome
    public boolean isPalindrome(ListNode head) {
        // Placeholder for your logic implementation

        //Stack approach with 1/2 Length, iterate and, pop and check with next element
        //2 pointers approach with 1/2 Length, iterate and, check with next element

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        ListNode current = head;
        //now iterate
        while (prev != null && current != null) {
            if (prev.val != current.val) return false;
            prev = prev.next;
            current = current.next;
        }

        return true;
    }

    // Helper function to print the list (for testing purposes)
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example 1: Palindrome list
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(1);

        _234_PalindromeLinkedList solution1 = new _234_PalindromeLinkedList();
        boolean result1 = solution1.isPalindrome(head1);
        System.out.println("Is Palindrome (Example 1): " + result1);  // Expected output: true

        // Example 2: Not a palindrome
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);

        _234_PalindromeLinkedList solution2 = new _234_PalindromeLinkedList();
        boolean result2 = solution2.isPalindrome(head2);
        System.out.println("Is Palindrome (Example 2): " + result2);  // Expected output: false
    }
}
