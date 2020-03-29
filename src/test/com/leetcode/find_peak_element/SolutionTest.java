package com.leetcode.find_peak_element;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void findPeakElement() {
        Solution sol = new Solution();
        int res1 = sol.findPeakElement(new int[]{1,2,3,1});
        assertEquals(2, res1);

        int res2 = sol.findPeakElement(new int[]{1,2,1,3,5,6,4});
        assertEquals(1, res2);
    }
}