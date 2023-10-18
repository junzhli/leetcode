package com.leetcode.word_break_ii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// https://leetcode.com/problems/word-break-ii/description/?envType=featured-list&envId=top-interview-questions
// backtracking, derived from word break non-solution, with result and curr
public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashMap<Character, List<String>> map = new HashMap<>();
        for (String word: wordDict) {
            char firstC = word.charAt(0);
            if (map.containsKey(firstC)) {
                List<String> list = map.get(firstC);
                list.add(word);
            } else {
                List<String> list = new ArrayList<>();
                list.add(word);
                map.put(firstC, list);
            }
        }

        List<String> result = new ArrayList<>();
        helper(s, 0, map, result, new ArrayList<>());
        return result;
    }

    private void helper(String s, int start, HashMap<Character, List<String>> map, List<String> result, List<String> curr) {
        if (start >= s.length()) {
            boolean firstTime = true;
            StringBuilder strBuilder = new StringBuilder();
            for (String str: curr) {
                if (firstTime) {
                    strBuilder.append(str);
                    firstTime = false;
                } else {
                    strBuilder.append(" ");
                    strBuilder.append(str);
                }
            }
            result.add(strBuilder.toString());
            return;
        }

        char firstC = s.charAt(start);
        if (map.containsKey(firstC)) {
            List<String> list = map.get(s.charAt(start));
            for (String str: list) {
                int length = str.length();
                if (start + length > s.length()) {
                    continue;
                }
                String sub = s.substring(start, start + length);
                if (str.equals(sub)) {
                    curr.add(str);
                    helper(s, start + length, map, result, curr);
                    curr.remove(curr.size() - 1);
                }
            }
        }


        return;
    }
}
