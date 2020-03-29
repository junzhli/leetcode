package com.leetcode.word_break;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void wordBreak() {
        Solution sol = new Solution();
        boolean res = sol.wordBreak("leetcode", Arrays.asList("leet", "code"));
        assertEquals(true, res);
    }
}