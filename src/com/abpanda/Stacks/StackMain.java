package com.abpanda.Stacks;

public class StackMain {
    public static void main(String[] args) {
        /*
        1. Create Stack
        2. Push
        3. Pop
        4. Peek
        5. isEmpty
        6. isFull
        7. deleteStack
        Stack can be implemented using Array (easy) and Linked List(not so easy implementation)
        */

        stackUsingArray newStack = new stackUsingArray(5);

        //isEmpty
        boolean isEmptyResult = newStack.isEmpty();
        System.out.println("Currently the stack isEmpty() ? : " + isEmptyResult);

        //isFull
        boolean isFullResult = newStack.isFull();
        System.out.println("Currently the stack isFull() ? : " + isFullResult);

        //Push
        newStack.push(62);
        newStack.push(61);
        newStack.push(60);
        newStack.push(70);
        newStack.push(99);
        newStack.push(100); //Full-Stack

        //Pop
        System.out.print(newStack.pop(5) + " ->Deleted Value");
        System.out.println("\nCurrent TopOfStack : " + newStack.topOfStack);

        //Peek
        System.out.println("Current Peek : " + newStack.peek());

        //Delete STack
//      newStack.deleteStack();

        /*****************************************************************************************************/
        /*****************************************************************************************************/
        /*****************************************************************************************************/




    }


}
