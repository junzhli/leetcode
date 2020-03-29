package com.leetcode.house_robber;

import java.util.Arrays;

public class Solution {
    /**
     * https://leetcode.com/problems/house-robber/
     *
     * best way to explain for cracking dp problems
     * https://leetcode.com/problems/house-robber/discuss/156523/From-good-to-great.-How-to-approach-most-of-DP-problems.
     *
     * 1. Find recursive relation
     * 2. Recursive (top-down)
     * 3. Recursive + memo (top-down)
     * 4. Iterative + memo (bottom-up)
     * 5. Iterative + N variables (bottom-up)
     *
     */

//    public int rob(int[] nums) {
//        /**
//         * Recursive (top-down)
//         *
//         * there are two options: a. rob at index i and sum up with the one before rob i - 2 b. not to rob at index i and sum up with the one before rob i - 1
//         * (find the recursive relation)
//         *
//         * except for those cases where nums.length is less than 3: 0, 1, 2
//         * otherwise, return Math.max(rob[selected elements of array from 0 to i - 2] + current value in house i, rob[selected elements of array from 0 to i -1])
//         *
//         * big o: n^2
//         */
//
//        if (nums.length == 0) {
//            return 0;
//        }
//
//        if (nums.length == 1) {
//            return nums[0];
//        }
//
//        if (nums.length == 2) {
//            return Math.max(nums[0], nums[1]);
//        }
//
//        int[] aArr = Arrays.copyOfRange(nums, 0, nums.length - 2);
//        int[] bArr = Arrays.copyOfRange(nums, 0, nums.length - 1);
//        return Math.max(rob(aArr) + nums[nums.length - 1], rob(bArr));
//    }

    int[] result;
    public int rob(int[] nums) {
        /**
         * Recursive + memo (top-down)
         *
         * there are two options: a. rob at index i and sum up with the one before rob i - 2 b. not to rob at index i and sum up with the one before rob i - 1
         * (find the recursive relation)
         *
         * except for those cases where nums.length is less than 3: 0, 1, 2
         * otherwise, return Math.max(rob[selected elements of array from 0 to i - 2] + current value in house i, rob[selected elements of array from 0 to i -1])
         *
         * big o: n^2
         */

        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] aArr = Arrays.copyOfRange(nums, 0, nums.length - 2);
        int[] bArr = Arrays.copyOfRange(nums, 0, nums.length - 1);
        return Math.max(rob(aArr) + nums[nums.length - 1], rob(bArr));
    }


//    public int rob(int[] nums) {
//        /**
//         * Bottom-up iterative + memorization
//         *
//         * there are two options: a. rob at index i and sum up with the one before rob i - 2 b. not to rob at index i and sum up with the one before rob i - 1
//         * (find the recursive relation)
//         *
//         * memorize and sum up values of robbing from bottom to top
//         * to start at index i, we set index 0 to 0
//         * finally, case by case, for i == 1, rob[i - 2] = rob[-1] = 0
//         * for others, Math.max(rob[i - 2] + nums[i - 1], rob[i - 1])
//         */
//
//        if (nums.length == 0) {
//            return 0;
//        }
//
//        int[] rob = new int[nums.length + 1];
//
//        for (int i = 0; i < nums.length + 1; i++) {
//            if (i == 0) {
//                rob[i] = 0;
//                continue;
//            }
//
//            if (i == 1) {
//                rob[i] = Math.max(nums[i - 1], rob[i - 1]); // nums[i - 1] originated from: rob[i - 2] + nums[i - 1]; where rob[i - 2] = rob[-1] = 0
//                continue;
//            }
//
//            rob[i] = Math.max(rob[i - 2] + nums[i - 1], rob[i - 1]);
//        }
//
//        return rob[nums.length];
//    }
}
