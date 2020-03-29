package com.leetcode.evaluate_reverse_polish_notation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void evalRPN() {
        Solution sol = new Solution();
        int ret = sol.evalRPN(new String[]{"2", "1", "+", "3", "*"});
        Assertions.assertEquals(9, ret);

        int ret2 = sol.evalRPN(new String[]{"4", "13", "5", "/", "+"});
        Assertions.assertEquals(6, ret2);

        int ret3 = sol.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"});
        Assertions.assertEquals(22, ret3);
    }
}