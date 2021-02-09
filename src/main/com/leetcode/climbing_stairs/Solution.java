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

    // round 3
    public int climbStairs(int n) {
        int[] cache = new int[n + 1];
        cache[0] = 1; // to make thing correct when i = 2
        cache[1] = 1;
        for (int i = 2; i < cache.length; i++) {
            int oneStep = cache[i - 1];
            int twoStep = cache[i - 2];
            cache[i] = oneStep + twoStep;
        }

        return cache[n];
    }

    // round 2
    // t.c. o(n)
    // s.c. o(n)
//    public int climbStairs(int n) {
//        int[] cache = new int[n + 1];
//        for (int i = 0; i < cache.length; i++) {
//            cache[i] = -1;
//        }
//
//        return helper(cache, n);
//    }
//
//    private int helper(int[] cache, int left) {
//        if (cache[left] != -1) {
//            return cache[left];
//        }
//
//        if (left == 0) {
//            return 1;
//        }
//
//        int res = 0;
//        if (left - 2 >= 0) {
//            res += helper(cache, left - 2);
//        }
//
//        if (left - 1 >= 0) {
//            res += helper(cache, left - 1);
//        }
//
//        cache[left] = res;
//        return res;
//    }

    // round 1
//    // dynamic programming tc: big o (n), sc: big o (n)
//    public int climbStairs(int n) {
//        int[] items = new int[n + 1];
//        if (n == 1) {
//            return 1;
//        }
//        if (n == 2) {
//            return 2;
//        }
//
//        items[1] = 1;
//        items[2] = 2;
//        for (int i = 3; i < n + 1; i ++) {
//            items[i] = items[i - 1] + items[i - 2];
//        }
//
//        return items[n];
//    }


}
