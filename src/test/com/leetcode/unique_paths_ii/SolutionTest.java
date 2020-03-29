package com.leetcode.unique_paths_ii;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void uniquePathsWithObstacles() {
        Solution sol = new Solution();
        sol.uniquePathsWithObstacles(new int[][]{
                new int[]{0,1,0,0,0},
                new int[]{1,0,0,0,0},
                new int[]{0,0,0,0,0},
                new int[]{0,0,0,0,0}
        });
    }
}