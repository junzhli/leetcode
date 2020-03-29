package com.leetcode.single_element_in_a_sorted_array;

public class Solution {
    /**
     * https://leetcode.com/problems/single-element-in-a-sorted-array
     */

//    public int singleNonDuplicate(int[] nums) {
//        /**
//         * Take advantage of bitwise xor operation:
//         * 0 ^ n = n
//         * n ^ n = 0
//         */
//
//        int xor = 0;
//        for (int index = 0; index < nums.length; index++) {
//            xor = xor ^ nums[index];
//        }
//
//        return xor;
//    }

    public int singleNonDuplicate(int[] nums) {
        /**
         * lo = 0, hi = nums.length - 1, mid
         *
         * four cases need to be considered
         * (1) non repeated one on the left side
         *   - odd  [1,1,2,3,3,4,4]
         *           l   h
         *   - even [1,1,2,3,3,4,4,5,5]
         *           l       h
         * (2) non repeated one on the right side
         *   - odd  [1,1,3,3,4,4,2]
         *                   l   h
         *   - even [1,1,3,3,4,4,2,5,5]
         *                   l       h
         *
         * get mid with given lo and hi (mid = lo + hi / 2 = lo + (hi - lo) / 2)
         * util lo >= hi
         */

        if(nums.length == 1) return nums[0];

        int lo = 0, hi = nums.length - 1;
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if(mid % 2 == 1) {
                if(nums[mid] == nums[mid+1]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if(nums[mid] == nums[mid-1]) {
                    hi = mid;
                } else {
                    lo = mid;
                }
            }
        }
        return nums[lo];
    }

}
