package com.leetcode.search_a_2d_matrix_ii;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void searchMatrix() {
        Solution sol = new Solution();
        int[][] mtx1 = new int[][]{
                new int[]{1,   4,  7, 11, 15},
                new int[]{2,   5,  8, 12, 19},
                new int[]{3,   6,  9, 16, 22},
                new int[]{10, 13, 14, 17, 24},
                new int[]{18, 21, 23, 26, 30},
        };
        boolean res1 = sol.searchMatrix(mtx1, 14);
        assertTrue(res1);

        boolean res2 = sol.searchMatrix(mtx1, 31);
        assertFalse(res2);

        boolean res3 = sol.searchMatrix(mtx1, 17);
        assertTrue(res3);
    }
}