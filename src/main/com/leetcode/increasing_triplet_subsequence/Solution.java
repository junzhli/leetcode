package com.leetcode.increasing_triplet_subsequence;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean increasingTriplet(int[] nums) {
        // start with two largest values, as soon as we find a number bigger than both, while both have been updated, return true.
        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= small) { small = n; } // update small if n is smaller than both
            else if (n <= big) { big = n; } // update big only if greater than small but smaller than big
            else {
                return true; // return if you find a number bigger than both
            }
        }
        return false;
    }

    // reference from 'longest increasing subsequence'
    // but it takes o(nlog(n)) as runtime time complexity
//    public boolean increasingTriplet(int[] nums) {
//        ArrayList<Integer> res = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (res.size() >= 3) { // !!
//                return true;
//            }
//
//            if (res.size() == 0) {
//                res.add(nums[i]);
//                continue;
//            }
//
//            int index = binarySearch(nums[i], res);
//            if (index == Integer.MAX_VALUE) {
//                res.add(nums[i]);
//            } else {
//                res.set(index, nums[i]);
//            }
//        }
//        return res.size() >= 3; // !!!!
//    }
//
//    private int binarySearch(int n, List<Integer> arr) {
//        int start = 0;
//        int end = arr.size() - 1;
//
//
//        while (start <= end) {
//            int mid = start + (end - start) / 2;
//            if (arr.get(mid) == n) {
//                while (mid - 1 >= 0 && arr.get(mid - 1) == n) {
//                    mid = mid - 1;
//                }
//                return mid;
//            } else if (arr.get(mid) < n) {
//                if (mid + 1 > arr.size() - 1) {
//                    return Integer.MAX_VALUE; // !!
//                }
//                start = mid + 1;
//            } else {
//                if (mid - 1 < 0 || (arr.get(mid - 1) < n)) {
//                    return mid;
//                }
//                end = mid - 1;
//            }
//        }
//
//        return -1;
//    }
}
