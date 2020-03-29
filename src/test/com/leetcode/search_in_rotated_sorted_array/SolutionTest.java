package com.leetcode.search_in_rotated_sorted_array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void search() {
        Solution sol = new Solution();
        int res1 = sol.search(new int[]{4,5,6,7,8,1,2,3}, 8);
        assertEquals(res1, 4);

        int res2 = sol.search(new int[]{8,1,2,3,4,5,6,7}, 6);
        assertEquals(res2, 6);

        int res3 = sol.search(new int[]{5,1,2,3,4}, 1);
        assertEquals(res3, 1);

        int res4 = sol.search(new int[]{4,5,6,7,0,1,2}, 3);
        assertEquals(res4, -1);

        int res5 = sol.search(new int[]{1,3}, 0);
        assertEquals(res5, -1);
    }
}