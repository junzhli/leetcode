package com.leetcode.word_ladder;

import javafx.util.Pair;

import java.util.*;

public class Solution {

    /**
     * BFS, using iteration rather than recursion
     *
     * refer to graph bfs solution: https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        int len = endWord.length();
        HashMap<String, ArrayList<String>> mapping = buildCombinations(wordList, len);
        HashMap<String, Boolean> visited = new HashMap<>();
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));

        while (!queue.isEmpty()) {
            Pair<String, Integer> p = queue.poll();
            String word = p.getKey();
            int level = p.getValue();
            for (int i = 0; i < len; i++) {
                String comb = word.substring(0, i) + "*" + word.substring(i + 1, len);
                for (String w: mapping.getOrDefault(comb, new ArrayList<>())) {
                    if (w.equals(endWord)) {
                        return level + 1;
                    }
                    if (!visited.containsKey(w)) {
                        visited.put(w, null);
                        queue.add(new Pair(w, level + 1));
                    }
                }
            }

        }
        return 0;
    }

    private HashMap<String, ArrayList<String>> buildCombinations(List<String> wordList, int len) {
        HashMap<String, ArrayList<String>> res = new HashMap<>();
        for (String word: wordList) {
            for (int i = 0; i < len; ++i) {
                String comb = word.substring(0, i) + "*" + word.substring(i + 1, len);
                ArrayList<String> val = res.getOrDefault(comb, new ArrayList<>());
                val.add(word);
                res.put(comb, val);
            }
        }

        return res;
    }

    /**
     * Solve this problem using backtracking, but failed when it comes with too long word-list as argument
     */
//    private int min;
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        if (!wordList.contains(endWord)) {
//            return 0;
//        }
//
//        min = wordList.size() + 1;
//        HashMap<String, Boolean> index = new HashMap<>();
//        index.put(beginWord, null);
//        helper(endWord, wordList, index, beginWord, 0);
//        return (min == wordList.size() + 1) ? 0 : min + 1;
//    }
//
//    private int helper(String endWord, List<String> wordList, HashMap<String, Boolean> visited, String curr, int len) {
//        if (endWord.equals(curr)) {
//            return len;
//        }
//
//        for (String word: wordList) {
//            if (visited.containsKey(word)) {
//                continue;
//            }
//
//            if (differFromAChar(curr, word)) {
//                visited.put(word, null);
//                int l = helper(endWord, wordList, new HashMap<>(visited), word, ++len);
//                if (l != 0 && l < min) {
//                    min = l;
//                }
//                len -= 1;
//                visited.remove(word);
//            }
//        }
//
//        return 0;
//    }
//
//    private boolean differFromAChar(CharSequence s1, CharSequence s2) {
//        if (s1 == s2) {
//            return false;
//        }
//
//        int count = 0;
//        for (int i = 0; i < s1.length(); i++) {
//            if (s1.charAt(i) == s2.charAt(i)) {
//                continue;
//            }
//
//            if (count == 1) {
//                return false;
//            }
//            count++;
//        }
//
//        return true;
//    }
}
