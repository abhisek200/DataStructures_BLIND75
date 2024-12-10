package com.leetcode.LinkedList;

public class _21_MergeTwoSortedLists {

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

    // Function to merge two sorted linked lists
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Placeholder for your logic implementation

        /**
         * Example
         * l1 : 1 -> 2 -> 3
         *      l1
         * l2 : 1->2->4->5->7->8
         *      l2
         * lNew : 0 -> 1 -> 2 -> 3 -> 4..
         * */

        ListNode headAbstarct = new ListNode(0);
        ListNode realList = headAbstarct;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                realList.next = list1;
                list1 = list1.next;
            } else {
                realList.next = list2;
                list2 = list2.next;
            }
            realList = realList.next;
        }
        if (list1 == null) {
            realList.next = list2;
        }
        if (list2 == null) {
            realList.next = list1;
        }
        return headAbstarct.next;

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
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        _21_MergeTwoSortedLists solution1 = new _21_MergeTwoSortedLists();
        ListNode result1 = solution1.mergeTwoLists(list1, list2);
        System.out.print("Merged List (Example 1): ");
        printList(result1);  // Expected output: [1, 1, 2, 3, 4, 4]

        // Example 2: Both lists are empty
        ListNode list3 = null;
        ListNode list4 = null;
        _21_MergeTwoSortedLists solution2 = new _21_MergeTwoSortedLists();
        ListNode result2 = solution2.mergeTwoLists(list3, list4);
        System.out.print("Merged List (Example 2): ");
        printList(result2);  // Expected output: []

        // Example 3: One list is empty
        ListNode list5 = null;
        ListNode list6 = new ListNode(0);
        _21_MergeTwoSortedLists solution3 = new _21_MergeTwoSortedLists();
        ListNode result3 = solution3.mergeTwoLists(list5, list6);
        System.out.print("Merged List (Example 3): ");
        printList(result3);  // Expected output: [0]
    }
}
