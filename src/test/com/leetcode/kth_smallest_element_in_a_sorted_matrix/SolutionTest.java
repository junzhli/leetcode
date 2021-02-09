package com.leetcode.kth_smallest_element_in_a_sorted_matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void kthSmallest() {
        Solution sol = new Solution();
        int ret = sol.kthSmallest(new int[][]{
                new int[]{1,5,9},
                new int[]{10,11,13},
                new int[]{12,13,15}
        }, 8);
        assertEquals(13, ret);
    }
}