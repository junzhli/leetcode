package com.leetcode.permutations_ii;

import java.util.*;

public class Solution {
    // round 2
    // time complexity: o(!n), where n = length of nums
    // space complexity: o(n)
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, res, new ArrayList<>(), used);
        return res;
    }

    private void helper(int[] nums, List<List<Integer>> res, List<Integer> comb, boolean[] used) {
        if (comb.size() == nums.length) {
            res.add(new ArrayList<>(comb));
        }

        for (int i = 0; i < nums.length; i++) {
            // e.g. when invoking self again to loop from i = 0, some elements must mark as visited
            if (used[i]) { // handles for simple case when it looping from beginning, it traverses some elements already included
                continue;
            }

            // e.g [1,1,2], if not handling, the result would come with duplicates: 1,1,2 ,, 1,1,2 ,, ...
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) { // handles cases to avoid duplicate of combinations
                continue;
            }


            comb.add(nums[i]);
            used[i] = true;
            helper(nums, res, comb, used);
            used[i] = false;
            comb.remove(comb.size() - 1);

        }
    }


    // round 1
//    public List<List<Integer>> permuteUnique(int[] nums) {
//        Arrays.sort(nums);
//        List<List<Integer>> res = new ArrayList<>();
//        _permute(nums, new ArrayList<>(), new boolean[nums.length], res);
//        return res;
//    }
//
//    private void _permute(int[] nums, List<Integer> tmpList, boolean[] used, List<List<Integer>> res) {
//        if (tmpList.size() == nums.length) {
//            res.add(new ArrayList<>(tmpList));
//            return;
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            if (used[i] || i != 0 && nums[i] == nums[i - 1] && !used[i - 1]) { // !important: !used[i - 1]
//                continue;
//            }
//
//            tmpList.add(nums[i]); // add possible step
//            used[i] = true;
//
//            _permute(nums, tmpList, used, res); // recursively find possible step
//
//            tmpList.remove(tmpList.size() - 1); // step back to continue to try next possible stop
//            used[i] = false;
//        }
//    }
}
