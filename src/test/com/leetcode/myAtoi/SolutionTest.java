package com.leetcode.myAtoi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void myAtoi() {
        Solution sol = new Solution();
        // input: 42
        String test1 = "42";
        int result1 = sol.myAtoi(test1);
        // output: 42
        assertEquals(42, result1);

        // input: -42
        String test2 = "-42";
        int result2 = sol.myAtoi(test2);
        // output: -42
        assertEquals(-42, result2);

        // input: 4193 with words
        String test3 = "4193 with words";
        int result3 = sol.myAtoi(test3);
        // output: 4193
        assertEquals(4193, result3);

        // input: words and 987
        String test4 = "words and 987";
        int result4 = sol.myAtoi(test4);
        // output: 0
        assertEquals(0, result4);

        // input: -91283472332
        String test5 = "-91283472332";
        int result5 = sol.myAtoi(test5);
        // output: -2147483648
        assertEquals(-2147483648, result5);

        // input: -
        String test6 = "-";
        int result6 = sol.myAtoi(test6);
        // output: 0
        assertEquals(0, result6);

        // input: +1
        String test7 = "+1";
        int result7 = sol.myAtoi(test7);
        // output: 1
        assertEquals(1, result7);

        // input: 200000000000000000000
        String test8 = "200000000000000000000";
        int result8 = sol.myAtoi(test8);
        // output: Integer.MAX_VALUE
        assertEquals(Integer.MAX_VALUE, result8);

        // input: +-2
        String test9 = "+-2";
        int result9 = sol.myAtoi(test9);
        // output: 0
        assertEquals(0, result9);

        // input:  +0 123
        String test10 = " +0 123";
        int result10 = sol.myAtoi(test10);
        // output: 0
        assertEquals(0, result10);

        // input:  - 234
        String test11 = "- 234";
        int result11 = sol.myAtoi(test11);
        // output: 0
        assertEquals(0, result11);

        // input:  -5-
        String test12 = "-5-";
        int result12 = sol.myAtoi(test12);
        // output: -5
        assertEquals(-5, result12);

        // input:  -13+8
        String test13 = "-13+8";
        int result13 = sol.myAtoi(test13);
        // output: -13
        assertEquals(-13, result13);

        // input:  123-
        String test14 = "123-";
        int result14 = sol.myAtoi(test14);
        // output: 123
        assertEquals(123, result14);

        // input:  2147483648
        String test15 = "2147483648";
        int result15 = sol.myAtoi(test15);
        // output: 2147483647
        assertEquals(2147483647, result15);
    }
}