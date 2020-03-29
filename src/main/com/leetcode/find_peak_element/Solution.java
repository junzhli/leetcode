package com.leetcode.find_peak_element;

public class Solution {
    // refer to https://leetcode.com/problems/find-peak-element/discuss/50232/Find-the-maximum-by-binary-search-(recursion-and-iteration)
    // iteration, recursion, sequential search

    public int findPeakElement(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private int helper(int[] nums, int start, int end) {
        if (start == end) {
            return start; // reach what we want
        }

        /**
         * if mid is not the local max (when comparing to mid2), the greater may present in the right range
         * mid (smaller) mid2 (greater) ==> mid2 ... (greater) ... end
         * mid (greater) mid2 (smaller) ==> start ... (greater) ... mid
         */
        int mid = (start + end) / 2;
        int mid2 = mid + 1;
        return (nums[mid] > nums[mid2]) ? helper(nums, start, mid) : helper(nums, mid2, end);
    }
}
