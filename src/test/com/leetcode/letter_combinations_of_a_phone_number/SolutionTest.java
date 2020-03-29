package com.leetcode.letter_combinations_of_a_phone_number;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void letterCombinations() {
        Solution sol = new Solution();

        String test1 = "23";
        List<String> result1 = sol.letterCombinations(test1);
        assertEquals(Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"), result1);
    }
}