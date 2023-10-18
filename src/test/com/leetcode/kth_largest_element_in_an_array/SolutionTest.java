package com.leetcode.kth_largest_element_in_an_array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void findKthLargest() {
        Solution sol = new Solution();
        int res = sol.findKthLargest(new int[]{3,2,1,5,6,4}, 3);
    }
}