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

        /**
         * (revised)
         * 0 1 2 3 4 5 6 7 8 9 0 1 2 (index)
         *
         * odd index, right side (lo = mid + 1)
         * 1 1 2 2 3 3 4 5 5 6 6 7 7
         *       |
         *
         * odd index, left side (hi = mid - 1)
         * 1 1 2 2 3 3 4 5 5 6 6 7 7
         *                   |
         *
         * even index, left side (lo = mid + 2)
         * 1 1 2 2 3 3 4 5 5 6 6 7 7
         *         |
         *
         * even index, right side (hi = mid)
         * 1 1 2 2 3 3 4 5 5 6 6 7 7
         *                     |
         *
         *
         * we notice that the single element "is always positioned at even index"!!!!!! (so in the even case, we need to care it's
         * possible that middle is answer, as opposed to mid at odd index)
         * so that's the reason we set hi as mid rather than mid - 1 when it comes to even index, right side
         *
         */

        if(nums.length == 1) return nums[0];

        int lo = 0, hi = nums.length - 1;
        while(lo < hi) {
            int mid = (lo + hi) / 2;

            if(mid % 2 == 1) { // position is odd, answer is not possible: mid + 1, mid - 1 can be possible
                if(nums[mid] == nums[mid-1]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            } else { // position is even
                if(nums[mid] == nums[mid+1]) {
                    lo = mid + 2;
                } else {
                    hi = mid; // we stay at mid as mid is possible to be answer
                }
            }
        }
        return nums[lo];
    }

}
