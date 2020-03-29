package com.leetcode.find_first_and_last_position_of_element_in_sorted_array;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class Solution {
    private int startP, endP;

    public int[] searchRange(int[] nums, int target) {
        // initialize result: start, end set as -1
        startP = -1;
        endP = -1;

        // edge cases handling
        if (nums.length == 0) {
            return new int[] {startP, endP};
        }

        if (nums.length == 1) {
            if (nums[0] == target) {
                return new int[] {0, 0};
            } else {
                return new int[] {startP, endP};
            }
        }


        int start = 0;
        int end = nums.length - 1;

        // find start position
        while (start < end) {
            int mid = (start + end) / 2;

            // narrow down as the cases
            // curr - 1 < curr (if idx(curr) > 0)
            if (mid > 0) {
                if (nums[mid] == target) {
                    if (nums[mid - 1] < nums[mid]) {
                        start = mid;
                        end = mid;
                        startP = mid;
                    } else {
                        end = mid - 1;
                    }
                } else {
                    if (nums[mid] < target) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
            } else {
                // mid == 0
                if (nums[mid] == target) {
                    start = mid;
                    end = mid;
                    startP = mid;
                } else {
                    if (nums[mid] < target) {
                        start = mid + 1;
                    } else {
                        start = -1;
                        end = -1;
                    }
                }
            }
        }

        if (start >= 0 && nums[start] == target) {
            startP = start;
        }

        // find the last position (skip if startP not found)
        if (startP != -1) {
            end = nums.length - 1;
            while (start < end) {
                int mid = (start + end) / 2;

                // narrow down as the case
                // curr > curr + 1 (if idx(curr) < nums.length - 1)
                if (mid < nums.length - 1) {
                    if (nums[mid] == target) {
                        if (nums[mid + 1] > nums[mid]) {
                            start = mid;
                            end = mid;
                            endP = mid;
                        } else {
                            start = mid + 1;
                        }
                    } else {
                        if (nums[mid] < target) {
                            start = mid + 1;
                        } else {
                            end = mid - 1;
                        }
                    }
                } else {
                    // mid == nums.length - 1
                    if (nums[mid] == target) {
                        start = mid;
                        end = mid;
                        endP = mid;
                    } else {
                        if (nums[mid] > target) {
                            end = mid - 1;
                        } else {
                            start = -1;
                            end = -1;
                        }
                    }
                }
            }
        }

        if (start >= 0 && nums[start] == target) {
            endP = start;
        }


        return new int[] {startP, endP};
    }
}
