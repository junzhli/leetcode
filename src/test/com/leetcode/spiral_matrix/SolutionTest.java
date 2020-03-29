package com.leetcode.spiral_matrix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void spiralOrder() {
        Solution sol = new Solution();
        int[][] req1 = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        Assertions.assertArrayEquals(Arrays.asList(new int[]{1,2,3,6,9,8,7,4,5}).toArray(), sol.spiralOrder(req1).toArray());
    }
}