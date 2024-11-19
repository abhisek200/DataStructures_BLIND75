package com.abpanda.LinkedLists.SinglyLinkedList;

public class SingleLinkedList {
    public Node head;
    public Node tail;
    public int size; //to get the number of nodes

    public Node createSLL(int nodeValue) {
        head = new Node();
        Node node = new Node(); // creating a nodeObject
        node.next = null;
        node.value = nodeValue;
        head = node; //referencing
        tail = node; //referencing
        size = 1;
        return head;
    }

    //    Insertion
    public void insertInSLL(int nodeValue, int locationIndex) {
        Node nodeNew = new Node();
        nodeNew.value = nodeValue;
        if (head == null) {
            createSLL(nodeValue);
        } else if (locationIndex == 0) {
            nodeNew.next = head; //head contains the 1st reference
            head = nodeNew; //head now referencing to new Node
        } else if (locationIndex >= size) {
            nodeNew.next = null;
            tail.next = nodeNew;
            tail = nodeNew;
        } else {
            Node tempNode = head;
            int index = 0;
            while (index < locationIndex - 1) {
                tempNode = tempNode.next;
                index++;
            }
            Node nextNode = tempNode.next;
            tempNode.next = nodeNew;
            nodeNew.next = nextNode;
        }
        size++;
    }

    //Traverse SLL
    public void traverSll() {
        if (head == null) {
            System.out.println("SLL doesn't exist!");
        } else {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if (i != size - 1) {
                    System.out.print("->");
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("\n");
    }

    public boolean searchSll(int searchValue) {
        if (head == null) {
            System.out.println("SLL not created");
            return false;
        } else {
            Node tempNode = head;
            for (int i = 0; i < size; i++, tempNode = tempNode.next) {
                if (tempNode.value == searchValue) {
                    System.out.println("Found the node at location : " + i);
                    System.out.println("Value : " + searchValue);
                    return true;
                }
            }
        }
        System.out.println("Node not found !");
        return false;
    }

    //delete in SLL
    public void deleteInSLL(int locationIndex) {
        if (head == null) {
            System.out.println("SLL doesn't exist.");
            return;
        } else if (locationIndex == 0) {
            head = head.next;
            size--;
            if (size == 0) {
                tail = null;
            }
        } else if (locationIndex >= size) {
            Node tempNode = head;
            for (int i = 0; i < size - 1; i++) {
                tempNode = tempNode.next;
            }
            if (tempNode == head) { //means only one node was present
                tail = head = null;
                size--;
            }
            tempNode.next = null;
            tail = tempNode;
            size--;
        } else { //deleting from a given location
            Node tempNode = head;
            for (int i = 0; i < locationIndex - 1; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next; //changing reference so that middle is no longer referenced
            size--;
        }
    }


    //delete entire SLL
    public void deleteEntireSLL() {
        head = tail = null;
        System.out.println("Single Linked list deleted successfully!");
    }
}
