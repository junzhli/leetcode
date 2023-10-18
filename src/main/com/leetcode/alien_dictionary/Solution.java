package com.leetcode.alien_dictionary;


import java.util.*;

// https://www.lintcode.com/problem/892/description
// https://leetcode.com/problems/alien-dictionary/?envType=featured-list&envId=top-interview-questions
public class Solution {
    // topological sort!!
    /**
     * @param words: a list of words
     * @return: a string which is correct order
     */
    private int letters = 0;

    public String alienOrder(String[] words) {
        letters = 0;
        // Write your code here
        int[] ins = new int[26];
        Arrays.fill(ins, -1);

        HashMap<Character, Set<Character>> adjs = new HashMap<>(); // goint to use hashset instead of arraylist, to avoid duplicates of edge between letters

        boolean valid = buildGraph(ins, words, adjs);
        if (!valid) {
            return "";
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((c1, c2) -> c1 - c2); // use priority queue rather than normal queue as required by the rules defined under the question: There may be multiple valid order of letters, return the smallest in normal lexicographical order.
        for (int i = 0; i < ins.length; i++) {
            if (ins[i] == 0) {
                pq.offer((char) (i + 'a'));
            }
            if (ins[i] != -1) {
                letters++;
            }
        }

        StringBuilder strBuilder = new StringBuilder();
        while (!pq.isEmpty()) {
            char c = pq.poll();
            strBuilder.append(c);
            if (adjs.containsKey(c)) {
                for (char a: adjs.get(c)) {
                    ins[a - 'a']--;
                    if (ins[a- 'a'] == 0) {
                        pq.offer(a);
                    }
                }
            }
        }

        return (strBuilder.length() == letters) ? strBuilder.toString() : "";
//        return strBuilder.toString();
    }

    private boolean buildGraph(int[] ins, String[] words, HashMap<Character, Set<Character>> adjs) {
        for (String w: words) {
            for (char c: w.toCharArray()) {
                ins[c - 'a'] = 0;
            }
        }

        for (int i = 1; i < words.length; i++) {
            String firstWord = words[i - 1];
            String secondWord = words[i];
            int len = Math.min(firstWord.length(), secondWord.length());
            char[] firstChars = firstWord.toCharArray();
            char[] secondChars = secondWord.toCharArray();
            for (int j = 0; j < len; j++) {

                // build edge from first -> secondChar at index i
                // if (ins[firstChars[j] - 'a'] == -1) {
                //     ins[firstChars[j] - 'a'] = 0;
                // }
                // if (ins[secondChars[j] - 'a'] == -1) {
                //     ins[secondChars[j] - 'a'] = 0;
                // }

                if (firstChars[j] != secondChars[j]) {
                    Set<Character> adj = adjs.getOrDefault(firstChars[j], new HashSet<>());
                    if (!adj.contains(secondChars[j])) { //!!!!!
                        ins[secondChars[j] - 'a']++;
                        adj.add(secondChars[j]);
                        adjs.putIfAbsent(firstChars[j], adj);
                    }
                    break; // !! stop checking once first different letter comes as it doesn't matter to those letters after the first
                }

                if (j == len - 1) { // to handle cases where both have same prefix but different letter and first word length is greater than second word
                    if (firstWord.length() > secondWord.length()) { // e.g. abc, ab by rule: The dictionary is invalid, if string a is prefix of string b and b is appear before a.
                        return false;
                    }
                }
            }



            // if (firstWord.length() > len) {
            //     for (int j = len; j < firstWord.length(); j++) {
            //         if (ins[firstChars[j] - 'a'] == -1) {
            //             ins[firstChars[j] - 'a'] = 0;
            //         }
            //     }
            // }
            // if (secondWord.length() > len) {
            //     for (int j = len; j < secondWord.length(); j++) {
            //         if (ins[secondChars[j] - 'a'] == -1) {
            //             ins[secondChars[j] - 'a'] = 0;
            //         }
            //     }
            // }
        }
        return true;
    }
}
