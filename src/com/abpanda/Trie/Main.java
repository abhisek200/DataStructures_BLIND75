package com.abpanda.Trie;

public class Main {
    public static void main(String[] args) {
        Trie TRIE = new Trie();
        TRIE.insertTrie("API");
        TRIE.insertTrie("APIS");
        TRIE.searchWordInTrie("AP");
    }
}
