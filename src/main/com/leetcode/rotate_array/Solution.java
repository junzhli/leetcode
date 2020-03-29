package com.leetcode.rotate_array;

public class Solution {
    public void rotate(int[] nums, int k) {
        int nordK = k % nums.length; // handles k which exceeds length of nums
        if (k == 0 || nordK == 0) { // ignore if offset is zero
            return;
        }

        // e.g. 1, 2, 3, 4, 5 | k = 2
        reverse(nums, 0, nums.length - 1); // 5, 4, 3, 2, 1
        reverse(nums, 0, nordK - 1); // 4, 5, 3, 2, 1
        reverse(nums, nordK, nums.length - 1); // 4, 5, 1, 2, 3
    }

    private void reverse(int[] nums, int start, int end) {
        int len = (int) Math.ceil((start + end) / 2.0);
        for (int i = start, j = 0; i < len; i++, j++) {
            int tmp = nums[i];
            nums[i] = nums[end - j];
            nums[end - j] = tmp;
        }
    }
}
