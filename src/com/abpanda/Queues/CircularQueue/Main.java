package com.abpanda.Queues.CircularQueue;

public class Main {
    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(3);
        System.out.println("isEmpty() ? : " + circularQueue.isEmpty());
        circularQueue.enQueue(9); // First-In | First-Out
        circularQueue.enQueue(99);
        circularQueue.enQueue(999);
        circularQueue.enQueue(899); // Not Allowed

        System.out.println("Value Removed in CQ : " + circularQueue.deQueue());
//        System.out.println("Value Removed in CQ : " + circularQueue.deQueue());
        System.out.println("Current Peek: " + circularQueue.peek());

        circularQueue.delete();

    }
}
