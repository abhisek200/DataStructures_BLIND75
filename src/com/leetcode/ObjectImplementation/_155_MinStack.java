package com.leetcode.ObjectImplementation;

public class _155_MinStack {

    Node head;

    public _155_MinStack() {
        // Constructor logic (initialize the stacks)
    }

    public static void main(String[] args) {
        // Test cases
        _155_MinStack minStack = new _155_MinStack();

        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("getMin(): " + minStack.getMin()); // Expected: -3

        minStack.pop();
        System.out.println("top(): " + minStack.top());       // Expected: 0
        System.out.println("getMin(): " + minStack.getMin()); // Expected: -2
    }

    public void push(int val) {
        Node newnNode = new Node(val);
        if (head == null) {
            head = newnNode;
            newnNode.min = val;
        } else {
            newnNode.min = Math.min(val, head.min);
            newnNode.next = head;
            head = newnNode;
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.value;
    }

    public int getMin() {
        return head.min;
    }

    public class Node {
        int value;
        int min;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }
}

