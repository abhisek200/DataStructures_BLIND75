package com.leetcode.LinkedList;

import java.util.List;

public class _206_ReverseLinkedList {

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

    // Function to reverse the linked list
    public ListNode reverseList(ListNode head) {
        // Placeholder for your logic implementation

        //      1 -> 2 -> 3 -> 4 -> 5
        // p <- c    n
        //      p    c    n
        //      1 <- 2 <- 3 <- 4 <- 5

        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev; // pointer change
            prev = current; //shift pointer
            current = nextNode;

        }
        return prev;
    }

    // Helper function to print the list for testing purposes
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example 1:
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);

        _206_ReverseLinkedList solution1 = new _206_ReverseLinkedList();
        ListNode result1 = solution1.reverseList(head1);
        System.out.print("Reversed List (Example 1): ");
        printList(result1);  // Expected output: [5, 4, 3, 2, 1]

        // Example 2:
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        _206_ReverseLinkedList solution2 = new _206_ReverseLinkedList();
        ListNode result2 = solution2.reverseList(head2);
        System.out.print("Reversed List (Example 2): ");
        printList(result2);  // Expected output: [2, 1]

        // Example 3: Empty list
        ListNode head3 = null;
        _206_ReverseLinkedList solution3 = new _206_ReverseLinkedList();
        ListNode result3 = solution3.reverseList(head3);
        System.out.print("Reversed List (Example 3): ");
        printList(result3);  // Expected output: []
    }
}
