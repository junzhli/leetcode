package com.leetcode.longest_common_prefix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void longestCommonPrefix() {
        Solution sol = new Solution();

        assertEquals("fl", sol.longestCommonPrefix(new String[]{"flower","flow","flight"}));
        assertEquals("", sol.longestCommonPrefix(new String[]{"dog","racecar","car"}));
        assertEquals("", sol.longestCommonPrefix(new String[]{"c","acc","ccc"}));
        assertEquals("", sol.longestCommonPrefix(new String[]{"aca","cba"}));
    }
}