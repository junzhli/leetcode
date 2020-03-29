package com.leetcode.gas_station;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void canCompleteCircuit() {
        Solution sol = new Solution();
        int[] gas = new int[]{1,2,3,4,5};
        int[] cost = new int[]{3,4,5,1,2};
        int res = sol.canCompleteCircuit(gas, cost);
        Assert.assertEquals(3, res);
    }
}