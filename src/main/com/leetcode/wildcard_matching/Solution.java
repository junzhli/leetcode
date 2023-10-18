package com.leetcode.wildcard_matching;

import java.util.HashSet;
import java.util.List;

public class Solution {
    // https://leetcode.com/problems/wildcard-matching/description/
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

        // edge cases handling (for empty s or empty p)
        dp[0][0] = true;
        for (int j = 1; j < p.length() + 1; j++) {
            char curP = p.charAt(j - 1);
            if (curP == '*') {
                dp[0][j] = dp[0][j-1];
            }
        }

        // main logic, result[s][p] is based on previous conditions
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < p.length() + 1; j++) {
                char curS = s.charAt(i - 1);
                char curP = p.charAt(j - 1);

                if (curS == curP || curP == '?') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (curP == '*') {
                    dp[i][j] = dp[i-1][j-1] || dp[i-1][j] || dp[i][j-1];
                }
            }
        }

        return dp[s.length()][p.length()];
    }
}
