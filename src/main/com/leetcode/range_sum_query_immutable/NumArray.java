package com.leetcode.range_sum_query_immutable;

// https://leetcode.com/problems/range-sum-query-immutable/description/
public class NumArray {
    private int[] sums;

    public NumArray(int[] nums) {
        this.sums = new int[nums.length];
        this.sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            this.sums[i] = nums[i] + this.sums[i-1];
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return this.sums[right];
        }
        return this.sums[right] - this.sums[left - 1];
    }
}
