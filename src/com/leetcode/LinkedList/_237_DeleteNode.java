package com.leetcode.LinkedList;

public class _237_DeleteNode {

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

    // Function to delete the given node
    public void deleteNode(ListNode node) {
        // Placeholder for your logic implementation

        // change the value / pointer
        node.val = node.next.val;
        node.next = node.next.next;
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
        ListNode head1 = new ListNode(4);
        head1.next = new ListNode(5);
        head1.next.next = new ListNode(1);
        head1.next.next.next = new ListNode(9);

        ListNode node1 = head1.next;  // Node to delete (value = 5)
        _237_DeleteNode solution1 = new _237_DeleteNode();
        solution1.deleteNode(node1);
        System.out.print("After deletion (Example 1): ");
        printList(head1);  // Expected output: [4, 1, 9]

        // Example 2:
        ListNode head2 = new ListNode(4);
        head2.next = new ListNode(5);
        head2.next.next = new ListNode(1);
        head2.next.next.next = new ListNode(9);

        ListNode node2 = head2.next.next;  // Node to delete (value = 1)
        _237_DeleteNode solution2 = new _237_DeleteNode();
        solution2.deleteNode(node2);
        System.out.print("After deletion (Example 2): ");
        printList(head2);  // Expected output: [4, 5, 9]
    }
}
