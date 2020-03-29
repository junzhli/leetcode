package com.leetcode.valid_parentheses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void isValid() {
        Solution sol = new Solution();

        Boolean res1 = sol.isValid("{}");
        assertEquals(true, res1);

        Boolean res2 = sol.isValid("}");
        assertEquals(false, res2);

        Boolean res3 = sol.isValid("((");
        assertEquals(false, res3);
    }
}