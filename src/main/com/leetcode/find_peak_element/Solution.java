package com.leetcode.find_peak_element;

public class Solution {
    // round 2
    // the problem wants us to return any of peak in the array,
    // the idea is to divide the array to find possible peak from left to right
    // the worst case would return the rightmost of the element in the array
    // it would be fine in the case;
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start < end) {
            mid = (start + end) / 2;

            if (nums[mid] > nums[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start; // returning start instead of mid is because the critical condition: start = mid + 1,
        // it will handle correctly in case of mid is less or equal to mid + 1
    }


    // round 1
    // refer to https://leetcode.com/problems/find-peak-element/discuss/50232/Find-the-maximum-by-binary-search-(recursion-and-iteration)
    // iteration, recursion, sequential search

//    public int findPeakElement(int[] nums) {
//        return helper(nums, 0, nums.length - 1);
//    }
//
//    private int helper(int[] nums, int start, int end) {
//        if (start == end) {
//            return start; // reach what we want
//        }
//
//        /**
//         * if mid is not the local max (when comparing to mid2), the greater may present in the right range
//         * mid (smaller) mid2 (greater) ==> mid2 ... (greater) ... end
//         * mid (greater) mid2 (smaller) ==> start ... (greater) ... mid
//         */
//        int mid = (start + end) / 2;
//        int mid2 = mid + 1;
//        return (nums[mid] > nums[mid2]) ? helper(nums, start, mid) : helper(nums, mid2, end);
//    }
}
