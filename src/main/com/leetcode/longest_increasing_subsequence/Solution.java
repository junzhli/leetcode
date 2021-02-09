package com.leetcode.longest_increasing_subsequence;

import java.util.Arrays;

// dp problem: bottom-up + memorization
public class Solution {

    // round 3
    public int lengthOfLIS(int[] array) {
        int [] LIS = new int [array.length];

        // step 1: set every element as max length = 1
        for (int i=0; i < array.length; i++) {
            LIS[i] = 1;
        }

        // step 2: iterate through the array to compare which result would get max if its precessdor is greater than it
        for (int i=1; i < array.length; i++) {
            for (int j=0; j<i; j++) {
                if (array[i] > array[j]) {
                    LIS[i] = Math.max(LIS[i], LIS[j] + 1);
                }
            }
        }

        // step 3: find max value
        int max = 0;
        for (int i=0; i<LIS.length; i++) {
            if (max < LIS[i])
                max = LIS[i];
        }
        return max;
    }

    // round 2
//    public int lengthOfLIS(int[] nums) {
//        if (nums.length == 0) {
//            return 0;
//        }
//
//        int[] tmpArr = new int[nums.length];
//
//        int size = 0;
//        tmpArr[0] = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            int j = size;
//            boolean less = false;
//            while (true) {
//                if (tmpArr[j] < nums[i]) {
//                    if (!less) {
//                        tmpArr[++size] = nums[i];
//                        break;
//                    } else {
//                        tmpArr[++j] = nums[i];
//                        break;
//                    }
//                } else if (tmpArr[j] == nums[i]) {
//                } else { // tmpArr[j] > nums[i]
//                    less = true;
//                }
//                j--;
//                if (j < 0) {
//                    tmpArr[++j] = nums[i];
//                    break;
//                }
//            }
//
//        }
//        return size + 1;
//    }

    // bottom-up
//    public int lengthOfLIS(int[] nums) {
//        if (nums.length == 0) {
//            return 0;
//        }
//
//        int max = 1;
//        int[] tmpArr = new int[nums.length]; // memorization
//        Arrays.fill(tmpArr, 1);
//
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j <= i; j++) {
//                if (nums[i] > nums[j]) {
//                    tmpArr[i] = Math.max(tmpArr[j] + 1, tmpArr[i]);
//                    max = Math.max(tmpArr[i], max);
//                }
//            }
//        }
//
//        return max;
//    }
}
