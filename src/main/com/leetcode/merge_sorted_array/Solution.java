package com.leetcode.merge_sorted_array;

/**
 * https://leetcode.com/problems/merge-sorted-array/submissions/
 */
public class Solution {

    // round 2
    // ** from right to left
    // t.c. o(n)
    // s.c. o(1)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int aPointer = m - 1;
        int bPointer = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            if (aPointer < 0) {
                nums1[i] = nums2[bPointer--];
            } else if (bPointer < 0) {
                nums1[i] = nums1[aPointer--];
            } else if (nums2[bPointer] >= nums1[aPointer]) {
                nums1[i] = nums2[bPointer--];
            } else {
                nums1[i] = nums1[aPointer--];
            }
        }
    }

    // round 1
//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        int nums1F = m - 1, nums2F = n - 1, allF = m + n - 1; // nums1.length - 1
//        while (nums1F >= 0 && nums2F >= 0) {
//            nums1[allF--] = (nums1[nums1F] > nums2[nums2F]) ? nums1[nums1F--] : nums2[nums2F--];
//        }
//
//        if (nums1F >= 0) {
//            for (; nums1F >= 0; nums1F--) {
//                nums1[allF--] = nums1[nums1F];
//            }
//        } else if (nums2F >= 0) {
//            for (; nums2F >= 0; nums2F--) {
//                nums1[allF--] = nums2[nums2F];
//            }
//        }
//    }
}
