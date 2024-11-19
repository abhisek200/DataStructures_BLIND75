package com.abpanda.BinaryTree;

public class Main {
    public static void main(String[] args) {
        BinaryTree BTREE = new BinaryTree();
        BTREE.insert("N1");
        BTREE.insert("N2");
        BTREE.insert("N3");
        BTREE.insert("N4");
        BTREE.insert("N5");
        BTREE.insert("N6");
        BTREE.levelOrder();
        BTREE.deleteNode("N1");
        BTREE.levelOrder();

    }
}
