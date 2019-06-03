package com.leetcode.zig_zag_conversion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void convert() {
        Solution sol = new Solution();
        // input: PAYPALISHIRING
        String test1 = "PAYPALISHIRING";
        int numRows1 = 3;
        String result1 = sol.convert(test1, numRows1);
        // output: PAHNAPLSIIGYIR
        assertEquals("PAHNAPLSIIGYIR", result1);

        // input: PAYPALISHIRING
        String test2 = "PAYPALISHIRING";
        int numRows2 = 4;
        String result2 = sol.convert(test2, numRows2);
        // output: PINALSIGYAHRPI
        assertEquals("PINALSIGYAHRPI", result2);

        // input: A
        String test3 = "A";
        int numRows3 = 1;
        String result3 = sol.convert(test3, numRows3);
        // output: A
        assertEquals("A", result3);

        // input: A
        String test4 = "A";
        int numRows4 = 2;
        String result4 = sol.convert(test4, numRows4);
        // output: A
        assertEquals("A", result4);

    }
}