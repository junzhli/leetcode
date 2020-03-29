package com.leetcode.permutations_two;

import java.util.*;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        _permute(nums, new ArrayList<>(), new boolean[nums.length], res);
        return res;
    }

    private void _permute(int[] nums, List<Integer> tmpList, boolean[] used, List<List<Integer>> res) {
        if (tmpList.size() == nums.length) {
            res.add(new ArrayList<>(tmpList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i != 0 && nums[i] == nums[i - 1] && !used[i - 1]) { // !important: !used[i - 1]
                continue;
            }

            tmpList.add(nums[i]); // add possible step
            used[i] = true;

            _permute(nums, tmpList, used, res); // recursively find possible step

            tmpList.remove(tmpList.size() - 1); // step back to continue to try next possible stop
            used[i] = false;
        }
    }
}
