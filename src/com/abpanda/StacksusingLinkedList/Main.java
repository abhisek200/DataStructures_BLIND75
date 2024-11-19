package com.abpanda.StacksusingLinkedList;

public class Main {
    public static void main(String[] args) {
        Stack newStack = new Stack();
        boolean isEmpty = newStack.isEmpty();
        System.out.println("is stack empty ? : " + isEmpty);
        newStack.push(11);
        newStack.push(12);
        newStack.push(13);
        newStack.push(14);
        boolean isEmpty2 = newStack.isEmpty();
        System.out.println("is stack empty ? : " + isEmpty2);

//        pop
        int result = newStack.pop();
        System.out.println("value popped : " + result);

//        peek
        System.out.println("current peek : " + newStack.peek());

//        deleteStack
        newStack.deleteStack();
    }
}
