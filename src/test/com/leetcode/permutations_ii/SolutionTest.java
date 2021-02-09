package com.leetcode.permutations_ii;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void permuteUnique() {
        Solution sol = new Solution();
//        System.out.println(sol.permuteUnique(new int[]{1, 1, 2}));
        System.out.println(sol.permuteUnique(new int[]{-1,2,-1,2,1,-1,2,1}));
    }
}