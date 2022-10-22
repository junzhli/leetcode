package com.leetcode.wiggle_sort;

public class Solution {
    // google
    // https://www.lintcode.com/problem/wiggle-sort/description
    // big o N
    // given unsorted array, reorder it such that nums[0] <= nums[1] >= nums[2] <= nums[3] ....
    // i.e. element at oven index < element at oven + 1 index
    // i.e. element at odd index > element at odd + 1 index

    // https://evelynn.gitbooks.io/google-interview/content/wiggle_sort.html
    public void wiggleSort(int[] nums) {
        if (nums.length < 2) {
            return;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            int j = i + 1;
            if (i % 2 == 0) { // even
                if (nums[i] > nums[j]) {
                    swap(nums, i , j);
                }
            } else { // odd
                if (nums[i] < nums[j]) {
                    swap(nums, i , j);
                }
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
