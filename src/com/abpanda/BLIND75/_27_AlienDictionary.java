package com.abpanda.BLIND75;

import java.util.*;

public class _27_AlienDictionary {
    public String alienOrder(String[] words) {
        // Step 1: Build the graph and in-degree map
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();

        // Initialize the graph and in-degree map for each character
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
                inDegree.putIfAbsent(c, 0);
            }
        }

        // Step 2: Compare adjacent words to find dependencies (edges in the graph)
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            int minLength = Math.min(word1.length(), word2.length());

            // Find the first different character
            for (int j = 0; j < minLength; j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);

                if (c1 != c2) {
                    // c1 comes before c2, add an edge from c1 -> c2
                    if (!graph.get(c1).contains(c2)) {
                        graph.get(c1).add(c2);
                        inDegree.put(c2, inDegree.get(c2) + 1);  // Increase the in-degree of c2
                    }
                    break;
                }
            }
        }

        // Step 3: Topological Sort using BFS (Kahn's Algorithm)
        Queue<Character> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        // Add all nodes with in-degree 0 to the queue
        for (char c : inDegree.keySet()) {
            if (inDegree.get(c) == 0) {
                queue.offer(c);
            }
        }

        // Process the graph
        while (!queue.isEmpty()) {
            char current = queue.poll();
            result.append(current);

            // Decrease in-degree of neighbors
            for (char neighbor : graph.get(current)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);

                // If in-degree becomes 0, add neighbor to queue
                if (inDegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Step 4: If the result length is equal to the number of unique characters, return the result
        // If not, it means there was a cycle (not all nodes were processed)
        if (result.length() == inDegree.size()) {
            return result.toString();
        } else {
            return "";  // Cycle detected, invalid order
        }
    }

    public static void main(String[] args) {
        _27_AlienDictionary alienLanguage = new _27_AlienDictionary();

        // Test case 1
        String[] words1 = {"wrt", "wrf", "er", "ett", "rftt"};
        System.out.println(alienLanguage.alienOrder(words1));  // Output: "wertf"

        // Test case 2
        String[] words2 = {"z", "x"};
        System.out.println(alienLanguage.alienOrder(words2));  // Output: "zx"
    }
}
