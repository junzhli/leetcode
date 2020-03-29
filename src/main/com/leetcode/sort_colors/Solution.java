package com.leetcode.sort_colors;

import com.sun.tools.corba.se.idl.InvalidArgument;

/**
 *
 * http://users.monash.edu/~lloyd/tildeAlgDS/Sort/Flag/ (an variant problem of Dutch National Flag)
 * 2 sort of this problem: 2 colors and 3 colors
 *
 * time complexity: big o n
 */
public class Solution {
    public void sortColors(int[] nums) throws InvalidArgument {
        if (nums.length <= 1) {
            return;
        }

        int low = 0, mid = 0, high = nums.length - 1;

        // notice that var mid increases when it comes to low or middle, not high
        // let's say there are 4 divisions in the array: low, medium, unknown, high
        // when its element equals low or medium, we swap between low/medium and unknown
        // and increase low/medium by 1. we have to decrease unknown by 1 for equation
        // when its element equals high, we swap between high and unknown too.
        // but now high sector being decreased by 1, which means high ones increases and also
        // unknown one decreases too. there is no need to decrease unknown by 1 by ourselves
        while (mid <= high) {
            switch (nums[mid]) {
                case 0: // 0 - (low - 1)
                    swap(nums, mid, low);
                    low++;
                    mid++;
                    break;
                case 1: // low - (mid - 1)
//                    swap(nums, mid, mid);
                    mid++;
                    break;
                case 2: // (high + 1) - (arr.length - 1)
                    swap(nums, high, mid);
                    high--;
                    break;
                default: // mid - high (unknown)
                    throw new InvalidArgument("unexpected value exists in array");
            }


        }
        utils.Array.printIntArray(nums);
    }

    private void swap(int[] nums, int idx1, int idx2) {
        int tmp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = tmp;
    }
}
