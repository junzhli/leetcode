package com.leetcode.decode_ways;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void numDecodings() {
        Solution sol = new Solution();
        System.out.println(sol.numDecodings("12"));
        System.out.println(sol.numDecodings("226"));
        System.out.println(sol.numDecodings("012")); // expected as 0
    }

}