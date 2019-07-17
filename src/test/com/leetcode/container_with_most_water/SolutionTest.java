package com.leetcode.container_with_most_water;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void maxArea() {
        Solution sol = new Solution();
        // input: [1,8,6,2,5,4,8,3,7]
        int[] test1 = new int[]{1,8,6,2,5,4,8,3,7};
        int result1 = sol.maxArea(test1);
        // output: 49
        assertEquals(49, result1);
    }
}