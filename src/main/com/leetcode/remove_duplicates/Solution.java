package com.leetcode.remove_duplicates;

public class Solution {

//    public int removeDuplicates(int[] nums) {
//        // cases handling when nums comes to 0 or 1
//        if (nums.length == 0) {
//            return 0;
//        }
//
//        if (nums.length == 1) {
//            return 1;
//        }
//
//        // case handling when nums is greater than 1
//        int beReplaced = 1; // pointer to the location be replaced
//        for (int x = 0; x < nums.length;) {
//            int y = x + 1; // y which is a pointer comparing its value to check its equation to x keeps an incremental addition until its mismatch.
//            while (y < nums.length) {
//                if (nums[y] == nums[x]) {
//                    y++;
//                } else {
//                    break;
//                }
//            }
//
//            if (y < nums.length) {
//                nums[beReplaced++] = nums[y];
//                x = y;
//            } else {
//                x++;
//            }
//        }
//
//        return beReplaced; // length of nums arr
//    }


    public int removeDuplicates(int[] nums) {
        /**
         * Solution fetched from Approach 1 on Leetcode: https://leetcode.com/problems/remove-duplicates-from-sorted-array/solution/
         * Key point: 2 pointers
         */
        int res = 0;
        if (nums.length == 0) {
            return res;
        }

        if (nums.length == 1) {
            return ++res;
        }

        for (int j = 1; j < nums.length; j++) {
            if (nums[res] != nums[j]) {
                nums[++res] = nums[j];
            }
        }

        return ++res;
    }

}
