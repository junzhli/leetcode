package com.leetcode.reverse_integer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void reverse() {
        Solution sol = new Solution();
        // input: 123
        int test1 = 123;
        int result1 = sol.reverse(test1);
        // output: 321
        assertEquals(321, result1);

        // input: -123
        int test2 = -123;
        int result2 = sol.reverse(test2);
        // output: -321
        assertEquals(-321, result2);

        // input: 120
        int test3 = 120;
        int result3 = sol.reverse(test3);
        // output: 21
        assertEquals(21, result3);

        // input: 10
        int test4 = 10;
        int result4 = sol.reverse(test4);
        // output: 1
        assertEquals(1, result4);

        // input: 1534236469
        int test5 = 1534236469;
        int result5 = sol.reverse(test5);
        // output: 0
        assertEquals(0, result5);

        // input: -2147483648
        int test6 = -2147483648;
        int result6 = sol.reverse(test6);
        // output: 0
        assertEquals(0, result6);

        // input: 1563847412
        int test7 = 1563847412;
        int result7 = sol.reverse(test7);
        // output: 0
        assertEquals(0, result7);

    }
}