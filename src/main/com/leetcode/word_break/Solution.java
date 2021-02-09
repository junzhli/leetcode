package com.leetcode.word_break;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
    // round 2 (wrong, tle)
    // backtracking
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.size() == 0) {
            return false;
        }

        if (s == null) {
            return false;
        }

        Collections.sort(wordDict, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        int minLen = wordDict.get(0).length();
        int maxLen = wordDict.get(wordDict.size() - 1).length();

        if (s.length() < minLen) {
            return false;
        }
        return helper(s, wordDict, 0, minLen, maxLen);
    }

    private boolean helper(String s, List<String> wordDict, int start, int min, int max) {
        if (start == s.length()) {
            return true;
        }

        for (int i = min; i <= max; i++) {
            if (start + i - 1 >= s.length()) {
                break;
            }

            String candicate = s.substring(start, start + i);
            if (wordDict.contains(candicate) && helper(s, wordDict, start + i, min, max)) {
                return true;
            }
        }

        return false;
    }


    // round 1
    // correct solution
//    public boolean wordBreak(String s, List<String> wordDict) {
//        if (s.length() == 0 || wordDict.size() == 0) {
//            return false;
//        }
//
//        boolean[] dp = new boolean[s.length() + 1]; // stands for whether str from 0 to i can be segmented into words form dict
//        // dynamic programming can reduce time computation with the help of memorizing
//        // whether str from 0 to i can be segmented when checks index starting from i + 1 to j
//
//        dp[0] = true;
//        for (int j = 1; j <= s.length(); j++) {
////            for (int i = 0; i < j; i++) {
//            for (int i = j - 1; i >= 0; i--) { // a little bit performance improvement for most of word with short length in word-list
//                if (dp[i] && wordDict.contains(s.substring(i, j))) {
//                    dp[j] = true;
//                }
//            }
//        }
//        return dp[s.length()];
//    }
}
