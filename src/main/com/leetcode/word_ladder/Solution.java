package com.leetcode.word_ladder;

import javafx.util.Pair;

import java.util.*;

public class Solution {

    // round 2
    // BFS: keypoint: find shortest path..., visited, while, queue, level
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        HashSet<String> wordSet = new HashSet<>(wordList);
        int level = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                String word = queue.poll();
                if (endWord.equals(word)) {
                    return level + 1;
                }
                for (int i = 0; i < word.length(); i++) {
                    char[] charArr = word.toCharArray();
                    for (char j = 'a'; j <= 'z'; j++) {
                        charArr[i] = j;
                        String newWord = new String(charArr);
                        if (!word.equals(newWord) && wordSet.contains(newWord)) {
                            wordSet.remove(newWord);
                            queue.offer(newWord);
                        }
                    }
                }
                size--;
            }
            level++;
        }

        return 0;

    }

    /**
     * BFS, using iteration rather than recursion
     *
     * refer to graph bfs solution: https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
     */
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        if (!wordList.contains(endWord)) {
//            return 0;
//        }
//
//        int len = endWord.length();
//        HashMap<String, ArrayList<String>> mapping = buildCombinations(wordList, len);
//        HashMap<String, Boolean> visited = new HashMap<>();
//        Queue<Pair<String, Integer>> queue = new LinkedList<>();
//        queue.add(new Pair(beginWord, 1));
//
//        while (!queue.isEmpty()) {
//            Pair<String, Integer> p = queue.poll();
//            String word = p.getKey();
//            int level = p.getValue();
//            for (int i = 0; i < len; i++) {
//                String comb = word.substring(0, i) + "*" + word.substring(i + 1, len);
//                for (String w: mapping.getOrDefault(comb, new ArrayList<>())) {
//                    if (w.equals(endWord)) {
//                        return level + 1;
//                    }
//                    if (!visited.containsKey(w)) {
//                        visited.put(w, null);
//                        queue.add(new Pair(w, level + 1));
//                    }
//                }
//            }
//
//        }
//        return 0;
//    }
//
//    private HashMap<String, ArrayList<String>> buildCombinations(List<String> wordList, int len) {
//        HashMap<String, ArrayList<String>> res = new HashMap<>();
//        for (String word: wordList) {
//            for (int i = 0; i < len; ++i) {
//                String comb = word.substring(0, i) + "*" + word.substring(i + 1, len);
//                ArrayList<String> val = res.getOrDefault(comb, new ArrayList<>());
//                val.add(word);
//                res.put(comb, val);
//            }
//        }
//
//        return res;
//    }

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
