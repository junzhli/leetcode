package com.leetcode.word_search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void exist() {
        Solution sol = new Solution();
        /**
         * [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
         * "ABCCED"
         */
        char[] a1 = new char[] {'A','B','C','E'};
        char[] a2 = new char[] {'S','F','C','S'};
        char[] a3 = new char[] {'A','D','E','F'};
        char[][] final1 = new char[][]{a1, a2, a3};
        System.out.println(sol.exist(final1, "ABCCED"));

    }
}