package com.google.single_element;

public class Solution {
    /**
     * https://leetcode.com/discuss/interview-question/346626/google-phone-screen-single-element
     */

    public static int singleElement(int... nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1; // lo + hi / 2
            int rightLen = hi - mid + 1;

            // 1,1,2,2,5,0,0


            // odd
            if ((rightLen & 1) == 1) { // check if the number is odd (faster and efficient than !(rightLen % 2))
                if (nums[mid] == nums[mid + 1]) {
                    lo = mid + 2;
                } else {
                    hi = mid;
                }
            }
            // even
            else {
                if (nums[mid] == nums[mid + 1]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
        }
        return nums[lo];
    }
}
