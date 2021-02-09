package com.leetcode.contains_duplicate;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    // use hashset by well known data structure: 6ms
    // ** hashset costs in a constant time (insert/get/contains)
//    public boolean containsDuplicate(int[] nums) {
//        HashSet<Integer> hashTable = new HashSet<>();
//        for (int n: nums) {
//            if (hashTable.contains(n)) {
//                return true;
//            }
//            hashTable.add(n);
//        }
//        return false;
//    }

    // by iteration with sorted array: 3ms
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }
}
