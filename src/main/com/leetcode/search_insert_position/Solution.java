package com.leetcode.search_insert_position;

public class Solution {
    // round 2
    // get the mid which positions to the closet index, check if it matches the target and return index;
    // if not then ++index; (by the request)
    // time complexity: o(log n)
    // space complexity: o(1)
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        if (nums[0] > target) {
            return start;
        }

        if (nums[end] < target) {
            return nums.length;
        }

        int mid = (start + end) / 2;
        while (start <= end) {
            mid = (start + end) / 2;
            if (mid == start) {
                break;
            }

            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                end = mid; // #1 (reason we don't use end = mid - 1, is because we are unable to know if mid would be answer
            } else {
                start = mid; // #2(reason we don't use start = mid + 1, is because we are unable to know if mid would be answer
            }
        }

//        // previous execution step should stop at #2
//        if (nums[mid] == target) {
//            return mid;
//        }
//
//        // previous execution step should stop at #1
//        return mid + 1;

        if (nums[start] < target) {
            return start + 1;
        } else {
            return start;
        }
    }

    // round 1
//    public int searchInsert(int[] nums, int target) {
//        // edge cases handling
//        if (target < nums[0]) {
//            return 0;
//        }
//        if (target > nums[nums.length - 1]) {
//            return nums.length;
//        }
//
//        // return possible solution which recursively uses binary search to find a possible match that is identical to target
//        int resIndex = _searchInsert(nums, 0, nums.length, target);
//        // as question requested, return ++resIndex if possible solution is not a match else return resIndex
//        if (nums[resIndex] != target) {
//            return ++resIndex;
//        } else {
//            return resIndex;
//        }
//    }
//
//    private int _searchInsert(int[] nums, int start, int end, int target) {
//        int middle = (start + end) / 2;
//        if (middle == start) {
//            return middle;
//        }
//        if (nums[middle] > target) {
//            return _searchInsert(nums, start, middle, target);
//        } else if (nums[middle] < target) {
//            return _searchInsert(nums, middle, end, target);
//        } else {
//            return middle;
//        }
//    }
}
