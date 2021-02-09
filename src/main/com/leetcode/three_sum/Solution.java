package com.leetcode.three_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum/
 */

public class Solution {
    // round 2
    // time complexity:
    // space complexity:
    public List<List<Integer>> threeSum(int[] nums) {
        // 3sums problem can be solved by fixed position at index i, and dynamic positions at index j, k, where j within range from i to k, and k at the end of array
        Arrays.sort(nums); // sorting is a must-have operation
        List<List<Integer>> res = new ArrayList<>();

        for (int index = 0; index < nums.length - 2; index++) {
            //**** check whether if duplicates exist in element k, shift right to skip
            // mismatch and then skip
            if (index > 0 && nums[index] == nums[index - 1]) {
                continue;
            }

            int i = nums[index];
            int index2 = index + 1;
            int index3 = nums.length - 1;
            while (index2 < index3) {
                int j = nums[index2];
                int k = nums[index3];

                //**** check whether if duplicates exist in element k, shift left to skip
                // mismatch and then skip
                if (index3 + 1 < nums.length && nums[index3] == nums[index3 + 1]) {
                    index3--;
                    continue;
                }

                int subtotal = i + j + k;
                if (subtotal < 0) {
                    index2++;
                } else if (subtotal > 0) {
                    index3--;
                } else {
                    List<Integer> ans = new ArrayList<>();
                    ans.add(i);
                    ans.add(j);
                    ans.add(k);
                    res.add(ans);
                    index2++;
                    index3--;
                }
            }
        }

        return res;
    }


    // round 1
//    public List<List<Integer>> threeSum(int[] nums) {
//        Arrays.sort(nums); // insertion sort: n^2 // hypothesis
//        List<List<Integer>> res = new ArrayList<>();
//
//        /**
//         *
//         * o(n^2)
//         * o(n^2 * log n)
//         *
//         * a, b, c, d, e, f, g..., z
//         * ^  ^                    ^
//         * i>>j -->            <-- k
//         *
//         * to avoid duplicate, we skip (i ,k)'s neighborhood who are the same as itself
//         *
//         * for best time complexity, we check the combinations that sums up as 0 by those pointers i, j, k
//         * we should sort the array in ascending order (-1, 1, 4, 7...)
//         *
//         * i is meant to start from 0
//         * j is meant to start from i + 1
//         * k is meant to start from the end of values
//         *
//         * finally, we increased j by 1 when i + j + k is less than 0
//         * decreased k by 1 when i + j + k is greater than 0
//         * wrote down the triplet when i + j + k equals 0
//         *
//         *
//         */
//
//        for (int index = 0; index < nums.length - 2; index++) {
//            int index2 = index + 1;
//            int index3 = nums.length - 1;
//
//            if (index > 0 && nums[index] == nums[index - 1]) {
//                continue;
//            }
//
//            int i = nums[index];
//            while (index3 > index2) {
//                int j = nums[index2];
//                int k = nums[index3];
//
//                if (index3 < nums.length - 1 && nums[index3] == nums[index3 + 1]) {
//                    index3--;
//                    continue;
//                }
//
//                if (i + j + k < 0) {
//                    index2++;
//                } else if (i + j + k > 0) {
//                    index3--;
//                } else {
//                    List<Integer> triplet = Arrays.asList(i , j , k);
//                    res.add(triplet);
//
//                    index2++;
//                    index3--;
//                }
//            }
//        }
//
//        return res;
//    }
}
