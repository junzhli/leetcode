package com.leetcode.coin_change;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void coinChange() {
        Solution sol = new Solution();
        int ret = sol.coinChange(new int[] {186,419,83,408}, 6249);
        assertEquals(20, ret);
    }
}