package com.leetcode.remove_element;

public class Solution {
    public int removeElement(int[] nums, int val) {
        /**
         * Two pointers (i, x) state the current index and the comparing index respectively
         */
        int i = 0;
        for (int x = 0; x < nums.length; x++) {
            if (nums[x] != val) {
                nums[i++] = nums[x];
            }
        }

        return i;
    }
}
