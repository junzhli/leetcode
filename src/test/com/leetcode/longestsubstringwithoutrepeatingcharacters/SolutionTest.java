package com.leetcode.longestsubstringwithoutrepeatingcharacters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    /**
     * Testing unit is out of scope, not in regular way
     */
    @Test
    void lengthOfLongestSubstring() {
        Solution sol = new Solution();
        // input: abcabcbb
        String test1 = "abcabcbb";
        int result1 = sol.lengthOfLongestSubstring(test1);
        // output: 3
        assertEquals(result1, 3);

        // input: bbbbb
        String test2 = "bbbbb";
        int result2 = sol.lengthOfLongestSubstring(test2);
        // output: 1
        assertEquals(result2, 1);

        // input: pwwkew
        String test3 = "pwwkew";
        int result3 = sol.lengthOfLongestSubstring(test3);
        // output: 3
        assertEquals(result3, 3);

        // implicit input: aab
        String test4 = "aab";
        int result4 = sol.lengthOfLongestSubstring(test4);
        // output: 2
        assertEquals(result4, 2);
    }
}