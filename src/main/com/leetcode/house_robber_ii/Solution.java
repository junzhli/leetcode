package com.leetcode.house_robber_ii;

// https://leetcode.com/problems/house-robber-ii/description/
// t.c. o(n)
// s.c. o(n)
public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dp1 = new int[nums.length]; // first house is exclusive
        dp1[0] = 0;
        dp1[1] = nums[1];
        for (int i = 2; i < nums.length - 1; i++) {
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + nums[i]);
        }
        dp1[nums.length - 1] = dp1[nums.length - 3] + nums[nums.length - 1];

        int[] dp2 = new int[nums.length]; // first house is inclusive, last house is exclusive
        dp2[0] = nums[0];
        dp2[1] = Math.max(dp2[0], nums[1]);
        for (int i = 2; i < nums.length - 1; i++) {
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + nums[i]);
        }
        dp2[nums.length - 1] = dp2[nums.length - 2];

        return Math.max(dp1[nums.length -1], dp2[nums.length -1]);
    }
}
