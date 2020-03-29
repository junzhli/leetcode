package com.leetcode.four_sum;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void fourSum() {
        Solution sol = new Solution();
        int[] test1 = new int[]{1, 0, -1, 0, -2, 2};
        List<List<Integer>> result1 = sol.fourSum(test1, 0);
//        assertEquals(42, result1);
        System.out.println(result1.toString());

        // [-1,0,1,2,-1,-4]
        //-1
        int[] test2 = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> result2 = sol.fourSum(test2, -1);
//        assertEquals(42, result1);
        System.out.println(result2.toString());
    }
}