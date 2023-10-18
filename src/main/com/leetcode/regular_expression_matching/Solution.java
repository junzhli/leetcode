package com.leetcode.regular_expression_matching;

public class Solution {
    public boolean isMatch(String s, String p) {
        // dp problem
        // https://leetcode.com/problems/regular-expression-matching/solutions/5651/easy-dp-java-solution-with-detailed-explanation/
        // t.c. o(n*m)
        // s.c. o(n*m)

        // !! edge case
        if (s == null || p == null) {
            return false;
        }

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1]; // represent if fist char at index in s can match first pattern char at index in p
        dp[0][0] = true; // because empty string always matches empty pattern

        // special case: string is empty (i = 0), pattern is not empty e.g. (a*) --> count as zero a
        for (int j = 2; j < p.length() + 1; j += 2) { // * always in even position, so we start with 2 and increment by 2
            int charAtP = p.charAt(j - 1);
            if (charAtP == '*' && dp[0][j - 2]) {
                dp[0][j] = true;
            }
        }

        // for cases where string always has no match for empty pattern, dp[i][0] = false

        // rest of cases in bottom-up manners
        // if s[i] = p[j], dp[i][j] = dp[i-1][j-1];
        // if p[j] = '.', dp[i][j] = dp[i-1][j-1];
        // if p[j] = '*', results in two sub-conditions
        //  --> if p[j-1] != '.' && p[j-1] != s[i], count as zero ?*, dp[i][j] = d[i][j-2]
        //  --> if p[j-1] == '.' && p[j-1] != s[i], count as zero ?*, dp[i][j] = d[i][j-2]
        //  --> if p[j-1] = s[i], dp[i][j] = dp[i-1][j-2]; (count once)
        //  --> if p[j-1] = s[i], dp[i][j] = dp[i-1][j]; (count multiple times)
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < p.length() + 1; j++) {
                char curS = s.charAt(i - 1);
                char curP = p.charAt(j - 1);

                if (curP == curS || curP == '.') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (curP == '*') {
                    char prevCurP = p.charAt(j - 2);
                    if (prevCurP != curS & prevCurP != '.') {
                        dp[i][j] = dp[i][j-2];
                    } else {
                        dp[i][j] = dp[i][j-2] || dp[i-1][j-2] || dp[i-1][j];
                    }
                }
            }
        }

        return dp[s.length()][p.length()];
    }
}
