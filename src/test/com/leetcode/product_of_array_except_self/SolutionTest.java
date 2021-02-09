package com.leetcode.product_of_array_except_self;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void productExceptSelf() {
        Solution sol = new Solution();
        int[] res = sol.productExceptSelf(new int[]{1,2,3,4});
        Assertions.assertArrayEquals(new int[]{24,12,8,6}, res);
    }
}