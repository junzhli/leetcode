package com.leetcode.integer_to_roman;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void intToRoman() {
        Solution sol = new Solution();

        assertEquals("IV", sol.intToRoman(4));
        assertEquals("III", sol.intToRoman(3));
        assertEquals("IX", sol.intToRoman(9));
        assertEquals("LVIII", sol.intToRoman(58));
        assertEquals("MCMXCIV", sol.intToRoman(1994));

    }
}