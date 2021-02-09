package com.leetcode.missing_number;

public class Solution {
//    public int missingNumber(int[] nums) { // sum
//        int numbers = nums.length + 1;
//        int max = nums.length;
//        int total = (0 + max) * numbers / 2;
//        int ret = total;
//        for (int n: nums) {
//            ret -= n;
//        }
//        return ret;
//    }

    public int missingNumber(int[] nums) { // xor
        int ret = nums.length;
        for (int i = 0; i < nums.length; i++) {
            ret ^= i;
            ret ^= nums[i];
        }
        return ret;
    }
}
