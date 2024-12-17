package com.leetcode.LinkedList;

// Definition for singly-linked list.
class ListNode {
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

public class _141_LinkedListCycle {
    //1->2->3->5(->2)
    //
    public boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Example usage:
        _141_LinkedListCycle solution = new _141_LinkedListCycle();

        // Create a linked list with a cycle for testing
        // Example 1: [3, 2, 0, -4], pos = 1
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;  // This creates a cycle (node4 -> node2)

        // Example 2: [1, 2], pos = 0
        ListNode node5 = new ListNode(1);
        ListNode node6 = new ListNode(2);
        node5.next = node6;
        node6.next = node5;  // This creates a cycle (node6 -> node5)

        // Example 3: [1], pos = -1
        ListNode node7 = new ListNode(1);  // No cycle here

        // Test cases
        System.out.println(solution.hasCycle(node1));  // Expected output: true (cycle exists)
        System.out.println(solution.hasCycle(node5));  // Expected output: true (cycle exists)
        System.out.println(solution.hasCycle(node7));  // Expected output: false (no cycle)
    }
}
