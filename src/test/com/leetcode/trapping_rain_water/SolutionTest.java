package com.leetcode.trapping_rain_water;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void trap() {
        Solution sol = new Solution();
        int res = sol.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
        assertEquals(6, res);

        int res2 = sol.trap(new int[]{2,0,2});
        assertEquals(2, res2);
    }
}