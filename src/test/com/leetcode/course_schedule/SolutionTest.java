package com.leetcode.course_schedule;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void canFinish() {
        Solution sol = new Solution();
        int[][] a1 = new int[][]{
                new int[] {1, 0},
                new int[] {0, 1}
        };
        boolean res1 = sol.canFinish(2, a1);
        assertEquals(false, res1);
    }
}