package com.leetcode.min_cost_climbing_stairs;

public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] cache = new int[cost.length];
        cache[0] = cost[0];
        cache[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            cache[i] = Math.min(cache[i - 1], cache[i - 2]) + cost[i];
        }

        return Math.min(cache[cache.length - 1], cache[cache.length - 2]);
    }
}
