package com.leetcode.friend_circles;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void findCircleNum() {
        Solution sol = new Solution();
        int res = sol.findCircleNum(new int[][] {
                new int[]{1,0,0,1},
                new int[]{0,1,1,0},
                new int[]{0,1,1,1},
                new int[]{1,0,1,1}
        });

        assertEquals(1, res);
    }
}