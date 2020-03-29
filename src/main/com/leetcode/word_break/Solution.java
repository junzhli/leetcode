package com.leetcode.word_break;

import java.util.List;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0 || wordDict.size() == 0) {
            return false;
        }

        boolean[] dp = new boolean[s.length() + 1]; // stands for whether str from 0 to i can be segmented into words form dict
        // dynamic programming can reduce time computation with the help of memorizing
        // whether str from 0 to i can be segmented when checks index starting from i + 1 to j

        dp[0] = true;
        for (int j = 1; j <= s.length(); j++) {
//            for (int i = 0; i < j; i++) {
            for (int i = j - 1; i >= 0; i--) { // a little bit performance improvement for most of word with short length in word-list
                if (dp[i] && wordDict.contains(s.substring(i, j))) {
                    dp[j] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
