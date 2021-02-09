package com.leetcode.longest_increasing_subsequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void lengthOfLIS() {
        Solution sol = new Solution();
        int res1 = sol.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
        assertEquals(4, res1);
        int res2 = sol.lengthOfLIS(new int[]{4,10,4,3,8,9});
        assertEquals(3, res2);
    }
}