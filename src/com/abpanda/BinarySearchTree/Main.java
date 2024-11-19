package com.abpanda.BinarySearchTree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree newBST = new BinarySearchTree();
        newBST.insert(10);
        newBST.insert(5);
        newBST.insert(4);
        newBST.insert(6);
        newBST.insert(14);
        newBST.insert(13);
        newBST.insert(15);
        newBST.preorderTraversal(newBST.root);
        System.out.println();
        newBST.inorderTraversal(newBST.root);
        System.out.println();
        newBST.postorderTraversal(newBST.root);
        System.out.println();
        newBST.levelOrderTraversal();
        System.out.println();
        newBST.searchMyTress(newBST.root, 15);
        System.out.println();
        newBST.deleteValue(newBST.root, 10);
        newBST.levelOrderTraversal();
    }
}
