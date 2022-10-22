package com.leetcode.median_of_two_sorted_arrays;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        if (total == 0) {
            return 0;
        }
        boolean odd = (total & 1) == 1;

        if (nums1.length == 0) {
            // only check nums2
            if (odd) {
                return nums2[(nums2.length - 1) / 2];
            } else {
                int leftIndex = (nums2.length - 1) / 2;
                int rightIndex = leftIndex + 1;
                return (double) (nums2[leftIndex] + nums2[rightIndex]) / (double) 2;
            }
        }
        if (nums2.length == 0) {
            // only checks nums1
            if (odd) {
                return nums1[(nums1.length - 1) / 2];
            } else {
                int leftIndex = (nums1.length - 1) / 2;
                int rightIndex = leftIndex + 1;
                return (double) (nums1[leftIndex] + nums1[rightIndex]) / (double) 2;
            }
        }
        if (odd) {
            int findIndex = (total - 1) / 2;
            int counter = 0;
            int nums1Index = 0;
            int nums2Index = 0;
            int tmp;
            while (counter < total) {
                if (nums1Index < nums1.length && nums2Index < nums2.length) {
                    if (nums1[nums1Index] < nums2[nums2Index]) {
                        tmp = nums1[nums1Index++];
                    } else {
                        tmp = nums2[nums2Index++];
                    }
                } else if (nums1Index < nums1.length) {
                    tmp = nums1[nums1Index++];
                } else if (nums2Index < nums2.length) {
                    tmp = nums2[nums2Index++];
                } else {
                    break;
                }
                if (counter == findIndex) {
                    return tmp;
                }
                counter++;
            }
        } else {
            int findLeftIndex = (total - 1) / 2;
            int findRightIndex = findLeftIndex + 1;
            int counter = 0;
            int nums1Index = 0;
            int nums2Index = 0;
            int tmp;
            int leftResult = Integer.MIN_VALUE;
            while (counter < total) {
                if (nums1Index < nums1.length && nums2Index < nums2.length) {
                    if (nums1[nums1Index] < nums2[nums2Index]) {
                        tmp = nums1[nums1Index++];
                    } else {
                        tmp = nums2[nums2Index++];
                    }
                } else if (nums1Index < nums1.length) {
                    tmp = nums1[nums1Index++];
                } else {
                    tmp = nums2[nums2Index++];
                }
                if (counter == findLeftIndex) {
                    leftResult = tmp;
                } else if (counter == findRightIndex) {
                    return ((double) leftResult + (double) tmp) / (double) 2;
                }
                counter++;
            }
        }
        return 0;
    }
}
