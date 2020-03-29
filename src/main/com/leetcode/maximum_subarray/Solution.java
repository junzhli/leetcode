package com.leetcode.maximum_subarray;

public class Solution {

    /**
     * https://leetcode.com/problems/maximum-subarray/
     */

    public int maxSubArray(int[] nums) {
        /**
         *
         */

        if (nums.length == 1) {
            return nums[0];
        }

        int max = nums[0]; // !should not initialize as 0

        for (int index = 1; index < nums.length; index++) {
            if (nums[index] + nums[index - 1] > nums[index]) {
                nums[index] = nums[index] + nums[index - 1];
            }

            if (nums[index] > max) {
                max = nums[index];
            }
        }

        return max;
    }

}
