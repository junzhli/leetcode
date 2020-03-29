package com.leetcode.search_insert_position;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        // edge cases handling
        if (target < nums[0]) {
            return 0;
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }

        // return possible solution which recursively uses binary search to find a possible match that is identical to target
        int resIndex = _searchInsert(nums, 0, nums.length, target);
        // as question requested, return ++resIndex if possible solution is not a match else return resIndex
        if (nums[resIndex] != target) {
            return ++resIndex;
        } else {
            return resIndex;
        }
    }

    private int _searchInsert(int[] nums, int start, int end, int target) {
        int middle = (start + end) / 2;
        if (middle == start) {
            return middle;
        }
        if (nums[middle] > target) {
            return _searchInsert(nums, start, middle, target);
        } else if (nums[middle] < target) {
            return _searchInsert(nums, middle, end, target);
        } else {
            return middle;
        }
    }
}
