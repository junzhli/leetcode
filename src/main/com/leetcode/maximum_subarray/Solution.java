package com.leetcode.maximum_subarray;

public class Solution {

    /**
     * https://leetcode.com/problems/maximum-subarray/
     */

    // round 2
    // avoid cumulative sum of n - 1 and element of n is less than element of n
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int subtotal = nums[0];
        int max = subtotal;
        for (int i = 1; i < nums.length; i++) {
            if (subtotal > 0) { // !@@@@@!!!!
                subtotal += nums[i];
            } else {
                subtotal = nums[i];
            }

            if (subtotal > max) {
                max = subtotal;
            }
        }

        return max;
    }

    // round 1
//    public int maxSubArray(int[] nums) {
//        /**
//         * https://leetcode.com/problems/maximum-subarray/discuss/20193/DP-solution-and-some-thoughts
//         */
//
//        if (nums.length == 1) {
//            return nums[0];
//        }
//
//        int max = nums[0]; // !should not initialize as 0
//
//        for (int index = 1; index < nums.length; index++) {
//            if (nums[index] + nums[index - 1] > nums[index]) { // (any) > 0 will continue the statement
//                nums[index] = nums[index] + nums[index - 1];
//            }
//
//            if (nums[index] > max) {
//                max = nums[index];
//            }
//        }
//
//        return max;
//    }

}
