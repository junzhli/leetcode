package com.leetcode.longest_increasing_subsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// see https://leetcode.com/problems/longest-increasing-subsequence/solutions/1326552/optimization-from-brute-force-to-dynamic-programming-explained/?envType=featured-list&envId=top-interview-questions
// explained https://www.youtube.com/watch?v=cjWnW0hdF1Y&t=192s
// dp problem: bottom-up + memorization
public class Solution {
    // round 4-4
    // binary indexed search
    public int lengthOfLIS(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (arr.size() == 0) {
                arr.add(nums[i]);
                continue;
            }

            int target = nums[i];
            int index = findLowestIndexWithGreaterValueThanX(target, arr);
            if (index == Integer.MAX_VALUE) {
                arr.add(target);
            } else if (index == Integer.MIN_VALUE) {
                arr.set(0, target);
            } else {
                arr.set(index, target);
            }
        }
        return arr.size();
    }

    private int findLowestIndexWithGreaterValueThanX(int x, List<Integer> arr) {
        int start = 0;
        int end = arr.size() - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr.get(mid) < x) {
                if (mid + 1 >= arr.size()) {
                    return Integer.MAX_VALUE;
                }
                start = mid + 1;
            } else {
                if (mid - 1 >= 0) {
                    if (arr.get(mid - 1) < x) {
                        return mid;
                    }
                    end = mid - 1;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
        }
        return -1;
    }

    // round 4-3
    // botton-up, memorization
//    public int lengthOfLIS(int[] nums) {
//        int[] dp = new int[nums.length];
//        Arrays.fill(dp, 1);
//        int max = -1; // we need this max var to keep the max record in the array i.e. not every time we can get longest one from index 0
//        for (int i = nums.length - 1; i >= 0; i--) {
//            for (int j = i; j < nums.length; j++) {
//                if (i == j) {
//                    continue;
//                }
//                if (nums[i] < nums[j]) {
//                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                }
//            }
//            max = Math.max(dp[i], max);
//        }
//        return max;
//    }

    // round 4-2
    // top-botton, memorization
//    public int lengthOfLIS(int[] nums) {
//        int[] dp = new int[nums.length]; // value at index i represents the largest increasing subsequence in range [i....n]; // notice that prevI would be the one that we keep the previously cauculated value since it matters to the result whatever i is
//        Arrays.fill(dp, -1);
//        return solve(nums, -1, 0, dp);
//    }
//
//    private int solve(int[] nums, int prevI, int i, int[] dp) {
//        if (i >= nums.length) {
//            return 0;
//        }
//
//        if (dp[prevI+1] != -1) { // the reason we store state as prevI+1 is to handle case of '-1'
//            return dp[prevI+1];
//        }
//
//        if (prevI == -1 || nums[i] > nums[prevI]) {
//            return dp[prevI+1] = Math.max(solve(nums, i, i + 1, dp) + 1, solve(nums, prevI, i + 1, dp));
//        } else {
//            return dp[prevI+1] = Math.max(0, solve(nums, prevI, i + 1, dp));
//        }
//    }

    // round 4-1
    // recursion, brute force
    // t.c. 
    // public int lengthOfLIS(int[] nums) {
    //     return solve(nums, Integer.MIN_VALUE, 0);
    // }

    // private int solve(int[] nums, int prev, int i) {
    //     if (i >= nums.length) {
    //         return 0;
    //     }

    //     if (nums[i] > prev) {
    //         return Math.max(solve(nums, nums[i], i + 1) + 1, solve(nums, prev, i + 1));
    //     } else {
    //         return Math.max(0, solve(nums, prev, i + 1));
    //     }
    // }

    // round 3
    // public int lengthOfLIS(int[] array) {
    //     int [] LIS = new int [array.length];

    //     // step 1: set every element as max length = 1
    //     for (int i=0; i < array.length; i++) {
    //         LIS[i] = 1;
    //     }

    //     // step 2: iterate through the array to compare which result would get max if its precessdor is greater than it
    //     for (int i=1; i < array.length; i++) {
    //         for (int j=0; j<i; j++) {
    //             if (array[i] > array[j]) {
    //                 LIS[i] = Math.max(LIS[i], LIS[j] + 1);
    //             }
    //         } 
    //     }

    //     // step 3: find max value
    //     int max = 0;
    //     for (int i=0; i<LIS.length; i++) {
    //         if (max < LIS[i])
    //             max = LIS[i];
    //     }
    //     return max;
    // }

    // round 2
//    public int lengthOfLIS(int[] nums) {
//        if (nums.length == 0) {
//            return 0;
//        }
//
//        int[] tmpArr = new int[nums.length];
//
//        int size = 0;
//        tmpArr[0] = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            int j = size;
//            boolean less = false;
//            while (true) {
//                if (tmpArr[j] < nums[i]) {
//                    if (!less) {
//                        tmpArr[++size] = nums[i];
//                        break;
//                    } else {
//                        tmpArr[++j] = nums[i];
//                        break;
//                    }
//                } else if (tmpArr[j] == nums[i]) {
//                } else { // tmpArr[j] > nums[i]
//                    less = true;
//                }
//                j--;
//                if (j < 0) {
//                    tmpArr[++j] = nums[i];
//                    break;
//                }
//            }
//
//        }
//        return size + 1;
//    }

    // bottom-up
//    public int lengthOfLIS(int[] nums) {
//        if (nums.length == 0) {
//            return 0;
//        }
//
//        int max = 1;
//        int[] tmpArr = new int[nums.length]; // memorization
//        Arrays.fill(tmpArr, 1);
//
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j <= i; j++) {
//                if (nums[i] > nums[j]) {
//                    tmpArr[i] = Math.max(tmpArr[j] + 1, tmpArr[i]);
//                    max = Math.max(tmpArr[i], max);
//                }
//            }
//        }
//
//        return max;
//    }
}
