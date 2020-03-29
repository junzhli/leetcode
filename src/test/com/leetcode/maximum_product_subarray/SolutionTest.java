package com.leetcode.maximum_product_subarray;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void maxProduct() {
        Solution sol = new Solution();
        int ret = sol.maxProduct(new int[]{2,3,-2,4});
        Assertions.assertEquals(6, ret);

        int ret2 = sol.maxProduct(new int[]{-2,0,-1});
        Assertions.assertEquals(0, ret2);

        int ret3 = sol.maxProduct(new int[]{-2,3,-4});
        Assertions.assertEquals(24, ret3);

        int ret4 = sol.maxProduct(new int[]{2,-5,-2,-4,3});
        Assertions.assertEquals(24, ret4);

        // [-1,-2,-9,-6]
        int ret5 = sol.maxProduct(new int[]{-1,-2,-9,-6});
        Assertions.assertEquals(108, ret5);
    }
}