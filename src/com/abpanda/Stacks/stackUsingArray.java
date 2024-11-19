package com.abpanda.Stacks;

public class stackUsingArray {
    int arr[];
    int topOfStack = -1;

    public stackUsingArray(int size) { //creating of stack
        this.arr = new int[size];
        this.topOfStack = -1;
        System.out.println("Stack successfully created for size : " + size);
    }

    public boolean isEmpty() {
        if (topOfStack == -1)
            return true;
        else
            return false;
    }

    public boolean isFull() {
        if (topOfStack == arr.length - 1) {
            return true;
        } else return false;
    }

    //Push
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full");
        } else {
            arr[topOfStack + 1] = value;
            topOfStack++;
            System.out.println(value + " is successfully inserted in the stack.");
        }
    }

    //Pop
    public int pop(int value) {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;
        } else {
            int topStackElement = arr[topOfStack];
            topOfStack--;
            return topStackElement;
        }
    }

    //Peek
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            return arr[topOfStack];
        }
    }

    //Delete Stack Method
    public void deleteStack(){
        arr = null;
        System.out.println("The Stack is Successfully deleted.");
    }
}
