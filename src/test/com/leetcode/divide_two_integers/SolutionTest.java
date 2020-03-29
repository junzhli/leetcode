package com.leetcode.divide_two_integers;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void divide() {
        Solution sol = new Solution();
        int res1 = sol.divide(10, 3);
        Assert.assertEquals(res1, 3);

        int res2 = sol.divide(-2147483648, 1);
        Assert.assertEquals(res2, -2147483648);
    }
}