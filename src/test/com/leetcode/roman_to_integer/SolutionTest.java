package com.leetcode.roman_to_integer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void romanToInt() {
        Solution sol = new Solution();

        assertEquals(3, sol.romanToInt("III"));
        assertEquals(4, sol.romanToInt("IV"));
        assertEquals(9, sol.romanToInt("IX"));
        assertEquals(58, sol.romanToInt("LVIII"));
    }
}