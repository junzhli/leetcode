package com.leetcode.rotate_image;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void rotate() {
        Solution sol = new Solution();
        sol.rotate(new int[][]{
                new int[]{1,2,3},new int[]{4,5,6},new int[]{7,8,9}
        });
    }
}