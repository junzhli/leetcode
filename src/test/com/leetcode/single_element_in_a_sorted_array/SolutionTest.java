package com.leetcode.single_element_in_a_sorted_array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void singleNonDuplicate() {
        Solution sol = new Solution();
        int[] input1 = new int[]{1,1,2,3,3,4,4,8,8};
        int res1 = sol.singleNonDuplicate(input1);
        assertEquals(2, res1);
    }
}