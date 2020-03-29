package com.leetcode.maximum_subarray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void maxSubArray() {
        Solution sol = new Solution();

        int[] input1 = new int[]{-2,1,-3,4,-1,2,1,-5,};
        int res1 = sol.maxSubArray(input1);
        assertEquals(6, res1);
    }
}