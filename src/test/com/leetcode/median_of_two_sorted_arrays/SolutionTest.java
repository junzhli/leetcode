package com.leetcode.median_of_two_sorted_arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void findMedianSortedArrays() {
        Solution sol = new Solution();
        int[] testA = new int[]{1,2};
        int[] testB = new int[]{3,4};
        double result = sol.findMedianSortedArrays(testA, testB);
        assertEquals(2.5, result);
    }
}