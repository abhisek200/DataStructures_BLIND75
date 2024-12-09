package com.leetcode.LinkedList;

import java.util.List;

public class _19_RemoveNthNodeFromEnd {

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

    // Function to remove the Nth node from the end of the list
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Placeholder for your logic implementation
        ListNode newhead = new ListNode(0);
        newhead.next = head;
        ListNode firstHead = newhead;
        ListNode lastHead = newhead;

        //create gap
        for (int i = 0; i < n; i++) {
            lastHead = lastHead.next;
        }

        //till tail
        while (lastHead.next != null) {
            firstHead = firstHead.next;
            lastHead = lastHead.next;
        }

        //implement delete node logic
        if(lastHead.next==null){
            firstHead.next = firstHead.next.next;
        }

        // 0 -> 1 -> 2 -> 3 -> 4 ... create a 0 N =3
        // s              f -> create 3 gap
        //      s              f -> till tail
        //0 -> 1 -> 3 -> 4 -> return from head, changed pointers, remove the current's next
        return newhead.next;
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

        int n1 = 2;  // Node to remove is the 2nd from the end
        _19_RemoveNthNodeFromEnd solution1 = new _19_RemoveNthNodeFromEnd();
        ListNode result1 = solution1.removeNthFromEnd(head1, n1);
        System.out.print("After removal (Example 1): ");
        printList(result1);  // Expected output: [1, 2, 3, 5]

        // Example 2:
        ListNode head2 = new ListNode(1);
        int n2 = 1;  // Only one node, remove it
        _19_RemoveNthNodeFromEnd solution2 = new _19_RemoveNthNodeFromEnd();
        ListNode result2 = solution2.removeNthFromEnd(head2, n2);
        System.out.print("After removal (Example 2): ");
        printList(result2);  // Expected output: []

        // Example 3:
        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(2);
        int n3 = 1;  // Remove last node
        _19_RemoveNthNodeFromEnd solution3 = new _19_RemoveNthNodeFromEnd();
        ListNode result3 = solution3.removeNthFromEnd(head3, n3);
        System.out.print("After removal (Example 3): ");
        printList(result3);  // Expected output: [1]
    }
}
