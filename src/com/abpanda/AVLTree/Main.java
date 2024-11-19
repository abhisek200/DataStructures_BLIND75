package com.abpanda.AVLTree;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        AVL newAVL = new AVL();
        newAVL.insert(5);
        newAVL.insert(10);
        newAVL.insert(15);
        newAVL.insert(20);
        newAVL.levelOrderTraversal();
        System.out.println();
        //BT : 5 -> 10 -> 15 -> 20
        //AVL BT : 10 -> 5 -> 15 -> 20
        newAVL.deleteMeFromAVL(5);
        newAVL.levelOrderTraversal();
    }
}
