package com.leetcode.climbing_stairs;

public class Solution {
    /**
     * https://leetcode.com/problems/climbing-stairs
     *
     * dynamic programming and 'recursive and memorization'
     *
     * https://leetcode.com/articles/climbing-stairs/#
     * concept:
     * (....."i - 1" + 1 step) + (....."i - 2" + 2 step) = result
     */

    // dynamic programming tc: big o (n), sc: big o (n)
    public int climbStairs(int n) {
        int[] items = new int[n + 1];
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        items[1] = 1;
        items[2] = 2;
        for (int i = 3; i < n + 1; i ++) {
            items[i] = items[i - 1] + items[i - 2];
        }

        return items[n];
    }


}
