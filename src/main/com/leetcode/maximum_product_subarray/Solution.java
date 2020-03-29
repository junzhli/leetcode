package com.leetcode.maximum_product_subarray;

public class Solution {
    private int max;
    private int[] segregated;
    private int[] segregatedMin;

    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        max = nums[0];
        segregated = new int[nums.length];
        segregatedMin = new int[nums.length];
        segregated[0] = nums[0];
        segregatedMin[0] = nums[0];
        for (int index = 1; index < nums.length; index++) {
            segregatedMin[index] = Math.min(Math.min(segregatedMin[index - 1] * nums[index], nums[index]), segregated[index - 1] * nums[index]); // *
            segregated[index] = Math.max(Math.max(segregated[index - 1] * nums[index], nums[index]), segregatedMin[index - 1] * nums[index]); // *
            if (segregated[index] > max) {
                max = segregated[index];
            }
        }

        return max;
    }
}
