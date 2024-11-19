package com.abpanda.StacksusingLinkedList;

public class Stack {
    LinkedList linkedList;

    public Stack() {
        linkedList = new LinkedList();
    }

    //    push method
    public void push(int value) {
        linkedList.insertInSLL(value, 0);
        System.out.println("inserted value " + value + " in stack!");
    }

    //    isEmpty
    public boolean isEmpty() {
        if (linkedList.head == null) {
            return true;
        } else {
            return false;
        }
    }

    //Pop method
    public int pop() {
        int result = -1;
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            result = linkedList.head.value;
            linkedList.deleteInSLL(0);
        }
        return result;
    }

    //    peek method
    public int peek() {
        int result = -1;
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            result = linkedList.head.value;
            return result;
//            linkedList.deleteInSLL(0);
        }
    }

    public void deleteStack() {
        linkedList.head = null;
        System.out.println("The Stack is Deleted.");
    }
}
