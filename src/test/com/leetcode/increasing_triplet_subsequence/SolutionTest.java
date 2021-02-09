package com.leetcode.increasing_triplet_subsequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void increasingTriplet() {
        Solution sol = new Solution();
        boolean res1 = sol.increasingTriplet(new int[]{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1,-1,-1,-1,3});
        boolean res2 = sol.increasingTriplet(new int[]{4,2,6});

        assertEquals(true, res1);
        assertEquals(false, res2);
    }
}