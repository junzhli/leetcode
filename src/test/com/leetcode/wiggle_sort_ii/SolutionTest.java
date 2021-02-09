package com.leetcode.wiggle_sort_ii;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void wiggleSort() {
        Solution sol = new Solution();
        sol.wiggleSort(new int[]{1,5,1,1,6,4});
        sol.wiggleSort(new int[]{5,3,1,2,6,7,8,5,5});
    }
}