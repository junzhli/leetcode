package com.leetcode.course_schedule_ii;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void findOrder() {
        Solution sol = new Solution();
        int[] res = sol.findOrder(7, new int[][] {
                new int[]{1,0},
                new int[]{0,3},
                new int[]{0,2},
                new int[]{3,2},
                new int[]{2,5},
                new int[]{4,5},
                new int[]{5,6},
                new int[]{2,4}
        });

        for (int i: res) {
            System.out.println(i);
        }
    }
}