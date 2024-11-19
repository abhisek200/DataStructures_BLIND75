package com.abpanda.Trie;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
        System.out.println("Trie has been created.");
    }

    public void insertTrie(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null) {
                node = new TrieNode(); // creates new node
                current.children.put(ch, node);
            }
            current = node; //loops existing if present
        }
        current.endOfString = true;
        System.out.println("Word Successfully inserted in Trie : " + word);
    }
    // o(M) both T/S

    public boolean searchWordInTrie(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null) {
                System.out.println("String not exists in Trie: " + word);
                return false;
            }
            current = node;
        }
        if (current.endOfString == true) {
            System.out.println("Word exists in TRIE: " + word);
            return true;
        } else {
            System.out.println("Prefix present but NOT the word you are looking for:- " + word);
            return false;
        }
//        return current.endOfString;
    }

    private boolean DeleteMe(TrieNode parentNode, String word, int index) {
        char ch = word.charAt(index);
        TrieNode currentNode = parentNode.children.get(ch);
        boolean canThisNodeBeDeleted;
        //1st
        // some other word prefix is same
        if (currentNode.children.size() > 1) {
            DeleteMe(currentNode, word, index + 1);
            return false;
        }
        //2nd
        //last char of the word but is a prefix
        if (index == word.length() - 1) {
            if (currentNode.children.size() >= 1) {
                currentNode.endOfString = false;
                return false;
            } else {
                parentNode.children.remove(ch);
                return true;
            }
        }
        //3rd
        //some other word is a prefix of this word
        if (currentNode.endOfString == true) {
            DeleteMe(currentNode, word, index + 1);
            return false;
        }
        //4th
        //no other node is dependent
        canThisNodeBeDeleted = DeleteMe(currentNode, word, index + 1);
        if (canThisNodeBeDeleted == true) {
            parentNode.children.remove(ch);
            return false;
        } else {
            return true;
        }
    }

    public void deleteTrie(String word) {
        if (searchWordInTrie(word) == true) {
            DeleteMe(root, word, 0);
        } else {
            System.out.println("word not found in TRIE.");
        }
    }

}
