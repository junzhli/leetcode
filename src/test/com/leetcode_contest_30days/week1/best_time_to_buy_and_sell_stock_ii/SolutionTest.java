package com.leetcode_contest_30days.week1.best_time_to_buy_and_sell_stock_ii;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void numSquares() {
        Solution sol = new Solution();
        int res1 = sol.numSquares(12);
        assertEquals(3, res1);
        int res2 = sol.numSquares(13);
        assertEquals(2, res2);
    }
}