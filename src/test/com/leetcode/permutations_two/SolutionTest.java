package com.leetcode.permutations_two;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void permuteUnique() {
        Solution sol = new Solution();
//        System.out.println(sol.permuteUnique(new int[]{1, 1, 2}));
        System.out.println(sol.permuteUnique(new int[]{-1,2,-1,2,1,-1,2,1}));
    }
}