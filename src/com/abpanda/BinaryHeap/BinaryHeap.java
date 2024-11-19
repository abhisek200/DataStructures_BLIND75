package com.abpanda.BinaryHeap;

import com.abpanda.Trie.TrieNode;

public class BinaryHeap {
    public int arr[];
    public int sizeOfTree; //size of heap

    BinaryHeap(int size) {
        // skipping the 0th index for null exceptions
        arr = new int[size + 1];
        this.sizeOfTree = 0;
        System.out.println("Binary Heap of size " + size + " has been created for Array Implementation, haha.");
    }

    public boolean isEmpty() {
        if (sizeOfTree == 0) {
            return true;
        }
        return false;
    }

    public Integer peek() {
        if (isEmpty()) {
            System.out.println("Binary Heap is Empty, returning null!");
            return null;
        } else {
            return arr[1];
        }
    }

    public Integer sizeOfBinaryHeap() {
        return sizeOfTree;
    }

    public void levelOrderTraversal() {
        for (int i = 1; i <= sizeOfTree; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");
    }


    //insertion
    //heap-ify method
    private void heapifyBottomToTopInsertion(int index, String heapType) {
        int parentIndex = index / 2;
        if (index <= 1) {
            //means at the root node
            return;
        }
        if (heapType == "MIN") {
            if (arr[index] < arr[parentIndex]) {
                int tempSwapValue = arr[index];
                arr[index] = arr[parentIndex];
                arr[parentIndex] = tempSwapValue;
            }
        } else if (heapType == "MAX") {
            if (arr[index] > arr[parentIndex]) {
                int tempSwapValue = arr[index];
                arr[index] = arr[parentIndex];
                arr[parentIndex] = tempSwapValue;
            }
        }
        //to check for all subTrees
        //O(logN)
        heapifyBottomToTopInsertion(parentIndex, heapType);
    }

    public void insert(int value, String heapType) {
        arr[sizeOfTree + 1] = value; //insert at bottom
        sizeOfTree++;
        heapifyBottomToTopInsertion(sizeOfTree, heapType);
        System.out.println("Value is inserted : " + value);
    }

    //extract node
    //helper : heapify Top to bottom
    private void heapifyTopToBottomReplacer(int index, String heapType) {
        int leftChildIndex = index * 2;
        int rightChildIndex = index * 2 + 1;
        int swapChild = 0;
        if (sizeOfTree < leftChildIndex) return;
        if (heapType == "MAX") {
            //1 child
            if (sizeOfTree == leftChildIndex) {
                if (arr[index] < arr[leftChildIndex]) {
                    int tempSwap = arr[index];
                    arr[index] = arr[leftChildIndex];
                    arr[leftChildIndex] = tempSwap;
                }
                return;
            } else {
                //2 children
                if (arr[leftChildIndex] > arr[rightChildIndex]) {
                    swapChild = leftChildIndex;
                } else swapChild = rightChildIndex;
                if (arr[index] < swapChild) {
                    int tempSwap = arr[index];
                    arr[index] = arr[swapChild];
                    arr[swapChild] = tempSwap;
                }
            }
        } else if (heapType == "MIN") {
            //1 child
            if (sizeOfTree == leftChildIndex) {
                if (arr[index] > arr[leftChildIndex]) {
                    int tempSwap = arr[index];
                    arr[index] = arr[leftChildIndex];
                    arr[leftChildIndex] = tempSwap;
                }
                return;
            } else {
                //2 children
                if (arr[leftChildIndex] < arr[rightChildIndex]) {
                    swapChild = leftChildIndex;
                } else swapChild = rightChildIndex;
                if (arr[index] > swapChild) {
                    int tempSwap = arr[index];
                    arr[index] = arr[swapChild];
                    arr[swapChild] = tempSwap;
                }
            }
        }
        heapifyTopToBottomReplacer(swapChild, heapType);
    }

    public int extractHeadOfBinaryHeap(String heapType) {
        //O(logN)
        if (isEmpty()) {
            return -1;
        } else {
            int extractedValue = arr[1]; //root
            arr[1] = arr[sizeOfTree];
            sizeOfTree--;
            heapifyTopToBottomReplacer(1, heapType);
            return extractedValue;
        }
    }

    public void deleteHeap() {
        arr = null;
        System.out.println("BinaryHeap has been Deleted.");
    }


}
