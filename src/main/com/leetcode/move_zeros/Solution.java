package com.leetcode.move_zeros;

// https://leetcode.com/problems/move-zeroes/submissions/998950476/?envType=featured-list&envId=top-interview-questions
public class Solution {
    // round 2 (similar to round 1, more elegant)
    // reference: https://leetcode.com/problems/move-zeroes/solutions/3549476/easy-java-solution-beats-99-9/?envType=featured-list&envId=top-interview-questions
    public void moveZeroes(int[] nums) {
        int i = 0;
        for (int num:nums){
            if(num != 0){
                nums[i] = num;
                i++;
            }
        }
        while(i<nums.length){
            nums[i] = 0;
            i++;
        }
    }

    // round 1
//    public void moveZeroes(int[] nums) {
//        int curr = 0; // current cursor
//        int zCurr = curr + 1; // cursor used to point to the one can be swapped when nums[curr] = 0 / always greater than curr
//        for (; zCurr < nums.length && curr < nums.length; curr++) {
//            if (nums[curr] != 0) {
//                if (zCurr <= curr) {
//                    zCurr = curr + 1; // to catch up with curr for zCurr
//                }
//                continue;
//            }
//
//            while (zCurr < nums.length && nums[zCurr] == 0) {
//                zCurr++; // find the next candidate to be swapped
//            }
//            if(zCurr >= nums.length) { // return if there's no candidate
//                return;
//            }
//
//            nums[curr] = nums[zCurr];
//            nums[zCurr++] = 0;
//        }
//    }
}
