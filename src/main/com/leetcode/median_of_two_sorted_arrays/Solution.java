package com.leetcode.median_of_two_sorted_arrays;

public class Solution {
    // round 1
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int total = nums1.length + nums2.length;
//        if (total == 0) {
//            return 0;
//        }
//        boolean odd = (total & 1) == 1;
//
//        if (nums1.length == 0) {
//            // only check nums2
//            if (odd) {
//                return nums2[(nums2.length - 1) / 2];
//            } else {
//                int leftIndex = (nums2.length - 1) / 2;
//                int rightIndex = leftIndex + 1;
//                return (double) (nums2[leftIndex] + nums2[rightIndex]) / (double) 2;
//            }
//        }
//        if (nums2.length == 0) {
//            // only checks nums1
//            if (odd) {
//                return nums1[(nums1.length - 1) / 2];
//            } else {
//                int leftIndex = (nums1.length - 1) / 2;
//                int rightIndex = leftIndex + 1;
//                return (double) (nums1[leftIndex] + nums1[rightIndex]) / (double) 2;
//            }
//        }
//        if (odd) {
//            int findIndex = (total - 1) / 2;
//            int counter = 0;
//            int nums1Index = 0;
//            int nums2Index = 0;
//            int tmp;
//            while (counter < total) {
//                if (nums1Index < nums1.length && nums2Index < nums2.length) {
//                    if (nums1[nums1Index] < nums2[nums2Index]) {
//                        tmp = nums1[nums1Index++];
//                    } else {
//                        tmp = nums2[nums2Index++];
//                    }
//                } else if (nums1Index < nums1.length) {
//                    tmp = nums1[nums1Index++];
//                } else if (nums2Index < nums2.length) {
//                    tmp = nums2[nums2Index++];
//                } else {
//                    break;
//                }
//                if (counter == findIndex) {
//                    return tmp;
//                }
//                counter++;
//            }
//        } else {
//            int findLeftIndex = (total - 1) / 2;
//            int findRightIndex = findLeftIndex + 1;
//            int counter = 0;
//            int nums1Index = 0;
//            int nums2Index = 0;
//            int tmp;
//            int leftResult = Integer.MIN_VALUE;
//            while (counter < total) {
//                if (nums1Index < nums1.length && nums2Index < nums2.length) {
//                    if (nums1[nums1Index] < nums2[nums2Index]) {
//                        tmp = nums1[nums1Index++];
//                    } else {
//                        tmp = nums2[nums2Index++];
//                    }
//                } else if (nums1Index < nums1.length) {
//                    tmp = nums1[nums1Index++];
//                } else {
//                    tmp = nums2[nums2Index++];
//                }
//                if (counter == findLeftIndex) {
//                    leftResult = tmp;
//                } else if (counter == findRightIndex) {
//                    return ((double) leftResult + (double) tmp) / (double) 2;
//                }
//                counter++;
//            }
//        }
//        return 0;
//    }

    // round 2
    // run at time complexity o(log(m + n))
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length+nums2.length];

        if (nums1.length == 0 && nums2.length == 0) {
            return (double) 0;
        } else {
            int p1 = 0;
            int p2 = 0;
            int pm = 0;
            while (p1 < nums1.length && p2 < nums2.length) {
                if (nums1[p1] <= nums2[p2]) {
                    merged[pm++] = nums1[p1++];
                } else {
                    merged[pm++] = nums2[p2++];
                }
            }

            while (p1 < nums1.length) {
                merged[pm++] = nums1[p1++];
            }

            while (p2 < nums2.length) {
                merged[pm++] = nums2[p2++];
            }
            return findMiddle(merged);
        }
    }

    private double findMiddle(int[] arr) {
        int start = 0;
        int end = arr.length -1;
        if (end % 2 != 0) {
            int first = end / 2;
            int second = end / 2 + 1;
            return ((double) (arr[first] + arr[second]) / (double) 2);
        } else {
            return (double) arr[end / 2];
        }
    }
}
