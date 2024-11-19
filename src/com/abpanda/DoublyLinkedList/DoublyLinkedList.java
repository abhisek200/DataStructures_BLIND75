package com.abpanda.DoublyLinkedList;

public class DoublyLinkedList {

    class DoublyNode {
        public int value;
        public DoublyNode next;
        public DoublyNode previous;
    }

    DoublyNode head;
    DoublyNode tail;
    int size;

    public DoublyNode createDLL(int nodeValue) {
        head = new DoublyNode();
        DoublyNode newNode = new DoublyNode();
        newNode.value = nodeValue;
        newNode.next = null;
        newNode.previous = null;
        head = tail = newNode;
        size = 1;
        return head;
    }

    public void insertDLL(int indexLocation, int nodeValue) {
        DoublyNode newNode = new DoublyNode();
        newNode.value = nodeValue;
        if (head == null) {
            createDLL(nodeValue);
            return;
        } else if (indexLocation == 0) {
            newNode.next = head;
            newNode.previous = null;
            head.previous = newNode;
            head = newNode;
        } else if (indexLocation >= size) {
            newNode.next = null;
            newNode.previous = tail;
            tail.next = newNode;
            tail = newNode;
        } else {
            DoublyNode tempNode = head;
            int index = 0;
            while (index < indexLocation - 1) {
                tempNode = tempNode.next;
                index++;
            }
            newNode.previous = tempNode;
            newNode.next = tempNode.next;
            tempNode.next = newNode;
            newNode.next.previous = newNode;
        }
        size++;
    }

    public void traversalDLL() {
        if (head != null) {
            DoublyNode tempNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if (i != size - 1) {
                    System.out.print("->");
                }
                tempNode = tempNode.next;
            }
        } else {
            System.out.println("The Dll doesn't not exists!");
        }
        System.out.println("\n");
    }

    public void reverseTraversal() {
        if (head != null) {
            DoublyNode tempNode = tail;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if (i != size - 1) {
                    System.out.print("<-");
                }
                tempNode = tempNode.previous;
            }
        } else {
            System.out.println("The Dll doesn't not exists!");
        }
        System.out.println("\n");
    }

    public boolean searchValueInDLL(int nodeValue) {
        if (head != null) {
            DoublyNode tempNode = head;
            for (int i = 0; i < size; i++, tempNode = tempNode.next) {
                if (tempNode.value == nodeValue) {
                    System.out.println("Node Found at indexLocation i : " + i);
                    return true;
                }
            }
        } else {
            System.out.println("The Dll doesn't not exists!");
        }
        System.out.println("Node not found.");
        return false;
    }

    public void deletionNodeValue(int indexLocation) {
        if (head != null) {
            if (indexLocation == 0) {
                if (size == 1) {
                    head = tail = null;
                    size--;
                } else {
                    head = head.next;
                    head.previous = null;
                    size--;
                }
            } else if (indexLocation >= size) {
                if (size == 1) {
                    head = tail = null;
                    size--;
                } else {
                    tail = tail.previous;
                    tail.next = null;
                    size--;
                }
            } else {
                DoublyNode currentNode = head;
                int index = 0;
                while (index < indexLocation - 1) {
                    currentNode = currentNode.next;
                    index++;
                }
                currentNode.next = currentNode.next.next;
                currentNode.next.previous = currentNode;
                size--;
            }
        } else {
            System.out.println("DLL doesn't exist");
        }
    }

    public void deleteEntireDLL() {
        head = tail = null;
    }
}
