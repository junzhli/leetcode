package com.leetcode.three_sum_closest;

import java.util.Arrays;

public class Solution {

    /**
     * https://leetcode.com/problems/3sum-closest/
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        boolean first = true;
        int closest = 0;
        int abs = 0;

        /**
         *
         * algorithm is similar with 'threeSum'
         *
         * subtle difference lists as below
         *
         * (1) target replaces 0
         * (2) record the shortest abs with the sum
         * (2) if (i + j + k == target) we return the target. program stopped here
         * (3) finally, return the sum recorded as the shortest abs
         *
         *
         *
         *
         */
        for (int index = 0; index < nums.length - 2; index++) {
            if (index > 0 && nums[index] == nums[index - 1]) {
                continue;
            }

            int index2 = index + 1;
            int index3 = nums.length - 1;

            while (index3 > index2) {
                if (index3 < nums.length - 1 && nums[index3] == nums[index3 + 1]) {
                    index3--;
                    continue;
                }

                int i = nums[index];
                int j = nums[index2];
                int k = nums[index3];
                int sum = i + j + k;
                if (sum > target || sum < target) {
                    if (sum > target) {
                        index3--;
                    } else {
                        // sum < target
                        index2++;
                    }

                    int _abs = Math.abs(sum - target);
                    if (first) {
                        abs = _abs;
                        closest = sum;
                        first = false;
                    } else {
                        if (_abs < abs) {
                            abs = _abs;
                            closest = sum;
                        }
                    }
                } else {
                    return target;
                }
            }
        }

        return closest;
    }

}
