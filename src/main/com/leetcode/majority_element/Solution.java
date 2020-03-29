package com.leetcode.majority_element;

public class Solution {
    public int majorityElement(int[] nums) {
        // https://www.cs.utexas.edu/~moore/best-ideas/mjrty/ majority vote algorithm

        int count = 1;
        int candidate = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (candidate == num) {
                count++;
            } else {
                if (count == 0) {
                    candidate = num;
                    count++;
                } else {
                    count--;
                }
            }
        }
        return candidate;
    }
}
