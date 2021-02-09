package com.leetcode.longest_substring_with_at_most_k_distinct_characters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void lengthOfLongestSubstringKDistinct() {
        Solution sol = new Solution();
        assertEquals(2, sol.lengthOfLongestSubstringKDistinct("araaci", 1));
    }
}