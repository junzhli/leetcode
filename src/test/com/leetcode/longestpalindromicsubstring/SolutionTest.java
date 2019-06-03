package com.leetcode.longestpalindromicsubstring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void longestPalindrome() {
        Solution sol = new Solution();
        // input: babad
        String test1 = "babad";
        String result1 = sol.longestPalindrome(test1);
        // output: bab
        assertEquals("bab", result1);

        // input: cbbd
        String test2 = "cbbd";
        String result2 = sol.longestPalindrome(test2);
        // output: bb
        assertEquals("bb", result2);

        // input: aaaabaaa
        String test3 = "aaaabaaa";
        String result3 = sol.longestPalindrome(test3);
        // output: bb
        assertEquals("aaabaaa", result3);

        // input: ccc
        String test4 = "ccc";
        String result4 = sol.longestPalindrome(test4);
        // output: ccc
        assertEquals("ccc", result4);
    }
}