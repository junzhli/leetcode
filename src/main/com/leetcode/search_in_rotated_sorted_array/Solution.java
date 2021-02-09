package com.leetcode.search_in_rotated_sorted_array;

public class Solution {

    // round 2
    // time complexity: o(log n)
    // space complexity: o(1)
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            if (target == nums[left]) {
                return left;
            }

            if (target == nums[right]) {
                return right;
            }

            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            }

            // in binary search algor., only focus on sorted array!!! ***
            if (nums[mid] > nums[left]) { // left side of array sorted
                if (target > nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // right side of array sorted
                if (target > nums[mid] && target < nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }




        return -1;
    }

//    public int search(int[] nums, int target) {
//        // edge case handling
//        if (nums.length == 0) {
//            return -1;
//        }
//
//        /**
//         * return value by recursion
//         */
//        return _search(nums, 0, nums.length - 1, target);
//    }
//
//    private int _search(int[] nums, int start, int end, int target) {
//        /**
//         * stop recursion when 'start' starts to be greater than 'end'
//         */
//        if (start > end) {
//            return -1;
//        }
//
//        /**
//         * edge cases handling
//         */
//        if (nums[start] == target) {
//            return start;
//        }
//        if (nums[end] == target) {
//            return end;
//        }
//
//        // get the middle index
//        int mid = (start + end) / 2;
//        // return if it gets a match with the target
//        if (nums[mid] == target) {
//            return mid;
//        }
//
//        // assume left side of the arr is sorted if value of middle is greater than value of start
//        if (nums[mid] > nums[start]) {
//            // continue to check if target ranges from value of middle to value of start
//            // if true, then recursively finds on the left side, else on the right side
//            if (nums[mid] > target && nums[start] <= target) {
//                return _search(nums, start, mid - 1, target);
//            } else {
//                return _search(nums, mid + 1, end, target);
//            }
//        } else if (nums[end] > nums[mid]) { // assume right side of the arr is sorted if value of end is greater than value of middle
//            // continue to check if target ranges from value of end to value of middle
//            // if true, then recursively finds on the right side, else on the left side
//            if (nums[mid] < target && nums[end] >= target) {
//                return _search(nums, mid + 1, end, target);
//            } else {
//                return _search(nums, start, mid - 1, target);
//            }
//        } else { // else return -1 which denotes 'not found'
//            return -1;
//        }
//    }
}
