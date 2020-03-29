package com.leetcode.minimum_path_sum;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void minPathSum() {
        Solution sol = new Solution();
        int res = sol.minPathSum(new int[][]{
            new int[]{1,3,1},
            new int[]{1,5,1},
            new int[]{4,2,1},
        });
        Assert.assertEquals(7, res);
    }
}