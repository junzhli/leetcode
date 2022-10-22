package com.leetcode.sort_colors;

//import com.sun.tools.corba.se.idl.InvalidArgument;

/**
 *
 * http://users.monash.edu/~lloyd/tildeAlgDS/Sort/Flag/ (an variant problem of Dutch National Flag)
 * 2 sort of this problem: 2 colors and 3 colors
 *
 * time complexity: big o n
 *
 * https://leetcode.com/problems/sort-colors/discuss/26549/Java-solution-both-2-pass-and-1-pass
 */
public class Solution {
    // round 3
    // better understanding than round 2
    public void sortColors(int[] nums) {
        // 1-pass
        int p1 = 0, p2 = nums.length - 1, index = 0;
        while (index <= p2) {
            if (nums[index] == 0) {
                nums[index] = nums[p1];
                nums[p1] = 0;
                p1++;
            }
            if (nums[index] == 2) {
                nums[index] = nums[p2];
                nums[p2] = 2;
                p2--;
                index--;
            }
            index++;
        }
    }


    // round 2
//    public void sortColors(int[] nums) {
//        int low = 0;
//        int mid = 0;
//        int high = nums.length - 1;
//
//        while (mid <= high) {
//            switch (nums[mid]) {
//                case 0:
//                    swap(nums, low++, mid++);
//                    break;
//                case 1:
//                    mid++;
//                    break;
//                case 2:
//                    swap(nums, high--, mid);
//                    break;
//            }
//        }
//    }
//
//    private void swap(int[] nums, int x, int y) {
//        int tmp = nums[x];
//        nums[x] = nums[y];
//        nums[y] = tmp;
//    }

    // round 1
//    public void sortColors(int[] nums) throws InvalidArgument {
//        if (nums.length <= 1) {
//            return;
//        }
//
//        int low = 0, mid = 0, high = nums.length - 1;
//
//        // notice that var mid increases when it comes to low or middle, not high
//        // let's say there are 4 divisions in the array: low, medium, unknown, high
//        // when its element equals low or medium, we swap between low/medium and unknown
//        // and increase low/medium by 1. we have to decrease unknown by 1 for equation
//        // when its element equals high, we swap between high and unknown too.
//        // but now high sector being decreased by 1, which means high ones increases and also
//        // unknown one decreases too. there is no need to decrease unknown by 1 by ourselves
//        while (mid <= high) {
//            switch (nums[mid]) {
//                case 0: // 0 - (low - 1)
//                    swap(nums, mid, low);
//                    low++;
//                    mid++;
//                    break;
//                case 1: // low - (mid - 1)
////                    swap(nums, mid, mid);
//                    mid++;
//                    break;
//                case 2: // (high + 1) - (arr.length - 1)
//                    swap(nums, high, mid);
//                    high--;
//                    break;
//                default: // mid - high (unknown)
//                    throw new InvalidArgument("unexpected value exists in array");
//            }
//
//
//        }
//        utils.Array.printIntArray(nums);
//    }
//
//    private void swap(int[] nums, int idx1, int idx2) {
//        int tmp = nums[idx1];
//        nums[idx1] = nums[idx2];
//        nums[idx2] = tmp;
//    }
}
