package com.leetcode.three_sum_closest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void threeSumClosest() {
        Solution sol = new Solution();

        // input: -1, 2, 1, -4
        int[] test1 = new int[]{-1, 2, 1, -4};
        int result1 = sol.threeSumClosest(test1, 1);
        // output: 2
        assertEquals(2, result1);

        // input: [1,1,1,0]
        //100
        int[] test2 = new int[]{1,1,1,0};
        int result2 = sol.threeSumClosest(test2, 100);
        // output: 3
        assertEquals(3, result2);
    }
}