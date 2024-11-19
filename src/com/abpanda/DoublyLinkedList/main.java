package com.abpanda.DoublyLinkedList;

import java.util.LinkedList;

public class main {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.createDLL(1);
//        dll.traversalDLL();
        dll.insertDLL(0, 2);
//        dll.traversalDLL();
        dll.insertDLL(0, 3);
//        dll.traversalDLL();
        dll.insertDLL(2, 4);
        dll.traversalDLL();
//        dll.reverseTraversal();
        dll.searchValueInDLL(9);
        dll.searchValueInDLL(4);
        System.out.println("before deleting : ");
        dll.traversalDLL();
        System.out.println("after deleting at index 2: ");
        dll.deletionNodeValue(2);
        dll.traversalDLL();

//        dll.deleteEntireDLL();
    }
}
