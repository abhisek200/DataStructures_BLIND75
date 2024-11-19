package com.abpanda.Queues.CircularQueue;

public class CircularQueue {

    int arr[];
    int topOfQueue;
    int beginningOfQueue;
    int size;

    public CircularQueue(int size) {
        this.arr = new int[size];
        this.size = size;
        this.topOfQueue = -1;
        this.beginningOfQueue = -1;
        System.out.println("Circular Queue is successfully created of size : " + size);
    }

    public boolean isEmpty() {
        if (topOfQueue == -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        if (topOfQueue + 1 == beginningOfQueue) {
            return true;
        } else if (beginningOfQueue == 0 && topOfQueue + 1 == size) {
            return true;
        } else //in all other cases it will return false
            return false;
    }

    public void enQueue(int value) {
        if (isFull()) {
            System.out.println("The Circular Queue is Full!!");
        } else if (isEmpty()) {
            beginningOfQueue = 0;
            topOfQueue++;
            arr[topOfQueue] = value;
            System.out.println("value added to queue : " + value);
        } else {
            if (topOfQueue + 1 == size) {
                topOfQueue = 0;
            } else {
                topOfQueue++;
            }
            arr[topOfQueue] = value;
            System.out.println("value added to queue : " + value);
        }
    }

    public int deQueue() {
        if (isEmpty()) {
            System.out.println("Bro, The Queue is Empty!");
            return Integer.MIN_VALUE;
        } else {
            int removalValue = arr[beginningOfQueue];
            arr[beginningOfQueue] = Integer.MIN_VALUE;
            if (beginningOfQueue == topOfQueue) {
                beginningOfQueue = topOfQueue = -1;
            } else if (beginningOfQueue + 1 == size) {
                beginningOfQueue = 0;
            } else {
                beginningOfQueue++;
            }
            return removalValue;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Bro, The Queue is Empty!");
            return Integer.MIN_VALUE;
        } else {
            return arr[beginningOfQueue];
        }
    }

    public void delete() {
        arr = null;
        System.out.println("Queue Successfully Deleted !");
    }
}
