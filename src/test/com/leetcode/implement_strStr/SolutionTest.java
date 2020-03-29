package com.leetcode.implement_strStr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void strStr() {
        Solution sol = new Solution();
        // haystack = "hello", needle = "ll"
        int res1 = sol.strStr("hello", "ll");
        assertEquals(res1, 2);
        // haystack = "aaaaa", needle = "bba"
        int res2 = sol.strStr("aaaaa", "bba");
        assertEquals(res2, -1);

        /**
         * "mississippi"
         * "issip"
         */
        // haystack = "aaaaa", needle = "bba"
        int res3 = sol.strStr("mississippi", "issip");
        assertEquals(res3, 4);
    }
}