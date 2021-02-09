package com.leetcode.search_a_2d_matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void searchMatrix() {
//        int[][] testCase = new int[][]{
//                new int[]{1,3,5,7},
//                new int[]{10,11,16,20},
//                new int[]{23,30,34,50},
//        };
        int[][] testCase = new int[][]{
                new int[]{1},
                new int[]{3},
        };
        Solution sol = new Solution();
        boolean ans = sol.searchMatrix(testCase, 3);
        assertEquals(true, ans);
    }
}