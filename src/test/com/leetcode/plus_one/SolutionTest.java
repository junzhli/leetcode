package com.leetcode.plus_one;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void plusOne() {
        Solution sol = new Solution();
        Assert.assertArrayEquals(new int[]{1,3,0}, sol.plusOne(new int[]{1,2,9}));
        Assert.assertArrayEquals(new int[]{1,0,0,0}, sol.plusOne(new int[]{9,9,9}));
        Assert.assertArrayEquals(new int[]{1}, sol.plusOne(new int[]{0}));
    }
}