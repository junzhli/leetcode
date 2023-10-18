package com.leetcode.fraction_to_recurring_decimal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void fractionToDecimal() {
        Solution sol = new Solution();
        sol.fractionToDecimal(4, 333);
        sol.fractionToDecimal(1, 90);
    }
}