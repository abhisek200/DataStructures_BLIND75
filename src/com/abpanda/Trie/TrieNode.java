package com.abpanda.Trie;

import java.util.*;

public class TrieNode {
    Map<Character, TrieNode> children;
    boolean endOfString;

    TrieNode() {
        children = new HashMap<>();
        endOfString = false;
    }
}
