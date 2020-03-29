package com.leetcode.excel_sheet_column_number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void titleToNumber() {
        Solution sol = new Solution();
        int res = sol.titleToNumber("AA");
        assertEquals(27, res);

        int res2 = sol.titleToNumber("ABC");
        assertEquals(731, res2);

        int res3 = sol.titleToNumber("ZY");
        assertEquals(701, res3);
    }
}