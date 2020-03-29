package com.leetcode.merge_sorted_array;

/**
 * https://leetcode.com/problems/merge-sorted-array/submissions/
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums1F = m - 1, nums2F = n - 1, allF = m + n - 1; // nums1.length - 1
        while (nums1F >= 0 && nums2F >= 0) {
            nums1[allF--] = (nums1[nums1F] > nums2[nums2F]) ? nums1[nums1F--] : nums2[nums2F--];
        }

        if (nums1F >= 0) {
            for (; nums1F >= 0; nums1F--) {
                nums1[allF--] = nums1[nums1F];
            }
        } else if (nums2F >= 0) {
            for (; nums2F >= 0; nums2F--) {
                nums1[allF--] = nums2[nums2F];
            }
        }
    }
}
